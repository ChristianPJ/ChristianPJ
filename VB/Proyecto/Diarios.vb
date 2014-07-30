Option Explicit On
Public Class Diarios

    Dim Fecha = Date.Today

    Private Sub Agregar_Click(sender As System.Object, e As System.EventArgs) Handles Agregar.Click
        main()

        If TextBox1.Text.Length = 2 Then
            Dim aux As String
            Dim aux2 As String
            Dim copia As String
            copia = TextBox1.Text
            aux = copia.Substring(0, 1)
            aux2 = copia.Substring(1, 1)
            If aux >= "A" And aux <= "Z" And IsNumeric(aux2) Then
                If Not (TextBox2.Text = String.Empty) And (TextBox2.Text.Length < 255) Then
                    comm.CommandText = "select * from TablaDiario where CodigoDiario= " & "'" & TextBox1.Text & "'"

                    Dim myReader As DataSet = New DataSet

                    datadp.Fill(myReader)

                    If myReader.Tables(0).Rows.Count = 0 Then
                        cnx.Close()

                        main()
                        If MsgBox("¿ Insertar: " + TextBox1.Text + " - " + TextBox2.Text + "?", vbOKCancel, "Confirmación") = vbOK Then
                            comm.CommandText = "insert into TablaDiario values ('" + TextBox1.Text + "','" + TextBox2.Text + "')"
                            comm.ExecuteNonQuery()
                            cnx.Close()

                            main()
                            comm.CommandText = "insert into TablaDiarioCambio values ('" + TextBox1.Text + "','" + TextBox2.Text + "','" + usuario + "','" + Fecha + "','Insertado')"
                            comm.ExecuteNonQuery()
                            cnx.Close()
                            Menupr.Estado.Text = "Insertado: Codigo(" + TextBox1.Text + ")"
                            Listar_Click(Nothing, Nothing)
                        End If
                    Else
                        MessageBox.Show("Código existente.")
                    End If
                Else
                    MessageBox.Show("Descripción incorrecta.")
                End If
            Else
                MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")
            End If
        Else
            MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")

        End If
        cnx.Close()
    End Sub

    Private Sub Modificar_Click(sender As System.Object, e As System.EventArgs) Handles Modificar.Click
        Dim des As String = ""
        cnx.Close()
        main()
        If TextBox1.Text.Length = 2 Then
            Dim aux As String
            Dim aux2 As String
            Dim copia As String
            copia = TextBox1.Text
            aux = copia.Substring(0, 1)
            aux2 = copia.Substring(1, 1)
            If aux >= "A" And aux <= "Z" And IsNumeric(aux2) Then
                If Not (TextBox2.Text = String.Empty) Then
                    comm.CommandText = "select * from TablaDiario where CodigoDiario= " & "'" & TextBox1.Text & "'"

                    Dim myReader As DataSet = New DataSet

                    datadp.Fill(myReader)

                    If myReader.Tables(0).Rows.Count > 0 Then
                        cnx.Close()
                        main()
                        des = myReader.Tables(0).Rows(0)("DescripcionDiario")
                        If MsgBox("¿ Modificar Codigo: " + TextBox1.Text + " " + Chr(13) + "  " + des + " por " + TextBox2.Text + "?", vbOKCancel, "Confirmación") = vbOK Then
                            comm.CommandText = "update TablaDiario set DescripcionDiario=" & "'" & TextBox2.Text & "' where CodigoDiario=" & "'" & TextBox1.Text & "'"
                            comm.ExecuteNonQuery()
                            cnx.Close()
                            main()
                            comm.CommandText = "insert into TablaDiarioCambio values ('" + TextBox1.Text + "','" + TextBox2.Text + "','" + usuario + "','" + Fecha + "','Modificado')"
                            comm.ExecuteNonQuery()
                            cnx.Close()
                            Listar_Click(Nothing, Nothing)
                        End If
                    Else
                        MessageBox.Show("Código no existente.")
                    End If
                Else
                    MessageBox.Show("Falta Descripción.")
                End If
            Else
                MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")
            End If
        Else
            MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")
        End If
        cnx.Close()

    End Sub

    Private Sub Borrar_Click(sender As System.Object, e As System.EventArgs) Handles Borrar.Click
        Dim des As String = ""

        main()

        If TextBox1.Text.Length = 2 Then
            Dim aux As String
            Dim aux2 As String
            Dim copia As String
            copia = TextBox1.Text
            aux = copia.Substring(0, 1)
            aux2 = copia.Substring(1, 1)
            If aux >= "A" And aux <= "Z" And IsNumeric(aux2) Then
                comm.CommandText = "select * from TablaDiario where CodigoDiario= " & "'" & TextBox1.Text & "'"

                Dim myReader As DataSet = New DataSet

                datadp.Fill(myReader)

                If myReader.Tables(0).Rows.Count > 0 Then
                    cnx.Close()
                    main()

                    comm.CommandText = "select * from TablaFacturas where Diario= " & "'" & TextBox1.Text & "'"

                    Dim myReader0 As DataSet = New DataSet

                    datadp.Fill(myReader0)

                    If myReader0.Tables(0).Rows.Count > 0 Then

                        MessageBox.Show("No puede eliminar un código mientras haya Apuntes/Facturas que lo usen.")

                    Else

                        cnx.Close()
                        main()
                        des = myReader.Tables(0).Rows(0)("DescripcionDiario")
                        If MsgBox("¿ Borrar: " + TextBox1.Text + "-" + des + "?", vbOKCancel, "Confirmación") = vbOK Then
                            comm.CommandText = "delete from TablaDiario where CodigoDiario=  " & "'" & TextBox1.Text & "'"
                            comm.ExecuteNonQuery()
                            cnx.Close()
                            main()
                            comm.CommandText = "insert into TablaDiarioCambio values ('" + TextBox1.Text + "','','" + usuario + "','" + Fecha + "','Borrado')"
                            comm.ExecuteNonQuery()
                            Menupr.Estado.Text = "Borrado: Codigo(" + TextBox1.Text + ")"
                            Listar_Click(Nothing, Nothing)
                        End If
                    End If
                Else

                    MessageBox.Show("Código no existente.")

                End If
            Else
                MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")
            End If

        Else
            MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")
        End If

        cnx.Close()
    End Sub

    Private Sub Detallar_Click(sender As System.Object, e As System.EventArgs) Handles Detallar.Click
        cnx.Close()
        main()

        If TextBox1.Text.Length = 2 Then
            Dim aux As String
            Dim aux2 As String
            Dim copia As String
            copia = TextBox1.Text
            aux = copia.Substring(0, 1)
            aux2 = copia.Substring(1, 1)
            If Not (IsNumeric(aux)) And IsNumeric(aux2) Then
                comm.CommandText = "select * from TablaDiarioCambio where CodigoDiario= " & "'" & TextBox1.Text & "' order by FechaDiario asc "

                Dim myReader As SqlClient.SqlDataReader

                myReader = comm.ExecuteReader()

                Dim DT As New DataTable

                DT.Load(myReader)

                DataGridView1.DataSource = DT
                DataGridView1.Columns(4).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill

            Else
                MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")
            End If
        Else
            MessageBox.Show("Código incorrecto. Debe tener una letra y una cifra.")
        End If
        cnx.Close()
    End Sub

    Private Sub Listar_Click(sender As System.Object, e As System.EventArgs) Handles Listar.Click
        cnx.Close()
        main()
        comm.CommandText = "select CodigoDiario Código, DescripcionDiario Descripción from TablaDiario order by CodigoDiario"

        Dim myReader As SqlClient.SqlDataReader

        myReader = comm.ExecuteReader()

        Dim DT As New DataTable

        DT.Load(myReader)

        DataGridView1.DataSource = DT
        DataGridView1.Columns(1).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
        cnx.Close()

    End Sub

    Private Sub Diarios_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        Label4.Text = "Usuario : " + usuario + ""

        If Principal.TPrivAñCo = "False" Then
            Agregar.Enabled = False
            Listar.Enabled = False
        Else
            Listar_Click(Nothing, Nothing)
        End If
        If Principal.TPrivMoCo = "False" Then
            Borrar.Enabled = False
            Modificar.Enabled = False
        End If
        If Principal.TPrivDeCo = "False" Then
            Detallar.Enabled = False
        End If

    End Sub

    Private Sub Imprimir_Click(sender As System.Object, e As System.EventArgs) Handles Imprimir.Click
        PrintDialog1.Document = PrintDocument1
        If (PrintDialog1.ShowDialog() = System.Windows.Forms.DialogResult.OK) Then
            PrintDocument1.Print()
        End If
    End Sub

    Private oStringFormat As StringFormat
    Private oStringFormatComboBox As StringFormat
    Private oButton As Button
    Private oCheckbox As CheckBox
    Private oComboBox As ComboBox

    Private nTotalWidth As Int16
    Private nRowPos As Int16
    Private NewPage As Boolean
    Private nPageNo As Int16
    Private Header As String = "Diarios"
    Private sUserName As String = "Empresa"

    Private Sub PrintDocument1_BeginPrint(ByVal sender As Object, ByVal e As System.Drawing.Printing.PrintEventArgs) Handles PrintDocument1.BeginPrint

        oStringFormat = New StringFormat
        oStringFormat.Alignment = StringAlignment.Near
        oStringFormat.LineAlignment = StringAlignment.Center
        oStringFormat.Trimming = StringTrimming.EllipsisCharacter

        oStringFormatComboBox = New StringFormat
        oStringFormatComboBox.LineAlignment = StringAlignment.Center
        oStringFormatComboBox.FormatFlags = StringFormatFlags.NoWrap
        oStringFormatComboBox.Trimming = StringTrimming.EllipsisCharacter

        oButton = New Button
        oCheckbox = New CheckBox
        oComboBox = New ComboBox

        nTotalWidth = 0
        For Each oColumn As DataGridViewColumn In DataGridView1.Columns

            nTotalWidth += oColumn.Width

        Next
        nPageNo = 1
        NewPage = True
        nRowPos = 0

    End Sub

    Private Sub PrintDocument1_PrintPage(ByVal sender As Object, ByVal e As System.Drawing.Printing.PrintPageEventArgs) Handles PrintDocument1.PrintPage

        Static oColumnLefts As New ArrayList
        Static oColumnWidths As New ArrayList
        Static oColumnTypes As New ArrayList
        Static nHeight As Int16

        Dim nWidth, i, nRowsPerPage As Int16
        Dim nTop As Int16 = e.MarginBounds.Top
        Dim nLeft As Int16 = e.MarginBounds.Left

        If nPageNo = 1 Then

            For Each oColumn As DataGridViewColumn In DataGridView1.Columns

                nWidth = CType(Math.Floor(oColumn.Width / nTotalWidth * nTotalWidth * (e.MarginBounds.Width / nTotalWidth)), Int16)

                nHeight = e.Graphics.MeasureString(oColumn.HeaderText, oColumn.InheritedStyle.Font, nWidth).Height + 11

                oColumnLefts.Add(nLeft)
                oColumnWidths.Add(nWidth)
                oColumnTypes.Add(oColumn.GetType)
                nLeft += nWidth

            Next

        End If

        Do While nRowPos < DataGridView1.Rows.Count - 1

            Dim oRow As DataGridViewRow = DataGridView1.Rows(nRowPos)

            If nTop + nHeight >= e.MarginBounds.Height + e.MarginBounds.Top Then

                DrawFooter(e, nRowsPerPage)

                NewPage = True
                nPageNo += 1
                e.HasMorePages = True
                Exit Sub

            Else

                If NewPage Then

                    ' Draw Header
                    e.Graphics.DrawString(Header, New Font(DataGridView1.Font, FontStyle.Bold), Brushes.Black, e.MarginBounds.Left, e.MarginBounds.Top - e.Graphics.MeasureString(Header, New Font(DataGridView1.Font, FontStyle.Bold), e.MarginBounds.Width).Height - 13)

                    ' Draw Columns
                    nTop = e.MarginBounds.Top
                    i = 0
                    For Each oColumn As DataGridViewColumn In DataGridView1.Columns

                        e.Graphics.FillRectangle(New SolidBrush(Drawing.Color.LightGray), New Rectangle(oColumnLefts(i), nTop, oColumnWidths(i), nHeight))
                        e.Graphics.DrawRectangle(Pens.Black, New Rectangle(oColumnLefts(i), nTop, oColumnWidths(i), nHeight))
                        e.Graphics.DrawString(oColumn.HeaderText, oColumn.InheritedStyle.Font, New SolidBrush(oColumn.InheritedStyle.ForeColor), New RectangleF(oColumnLefts(i), nTop, oColumnWidths(i), nHeight), oStringFormat)
                        i += 1

                    Next
                    NewPage = False

                End If

                nTop += nHeight
                i = 0
                For Each oCell As DataGridViewCell In oRow.Cells

                    If oColumnTypes(i) Is GetType(DataGridViewTextBoxColumn) OrElse oColumnTypes(i) Is GetType(DataGridViewLinkColumn) Then

                        e.Graphics.DrawString(oCell.Value.ToString, oCell.InheritedStyle.Font, New SolidBrush(oCell.InheritedStyle.ForeColor), New RectangleF(oColumnLefts(i), nTop, oColumnWidths(i), nHeight), oStringFormat)

                    ElseIf oColumnTypes(i) Is GetType(DataGridViewButtonColumn) Then

                        oButton.Text = oCell.Value.ToString
                        oButton.Size = New Size(oColumnWidths(i), nHeight)
                        Dim oBitmap As New Bitmap(oButton.Width, oButton.Height)
                        oButton.DrawToBitmap(oBitmap, New Rectangle(0, 0, oBitmap.Width, oBitmap.Height))
                        e.Graphics.DrawImage(oBitmap, New Point(oColumnLefts(i), nTop))

                    ElseIf oColumnTypes(i) Is GetType(DataGridViewCheckBoxColumn) Then

                        oCheckbox.Size = New Size(14, 14)
                        oCheckbox.Checked = CType(oCell.Value, Boolean)
                        Dim oBitmap As New Bitmap(oColumnWidths(i), nHeight)
                        Dim oTempGraphics As Graphics = Graphics.FromImage(oBitmap)
                        oTempGraphics.FillRectangle(Brushes.White, New Rectangle(0, 0, oBitmap.Width, oBitmap.Height))
                        oCheckbox.DrawToBitmap(oBitmap, New Rectangle(CType((oBitmap.Width - oCheckbox.Width) / 2, Int32), CType((oBitmap.Height - oCheckbox.Height) / 2, Int32), oCheckbox.Width, oCheckbox.Height))
                        e.Graphics.DrawImage(oBitmap, New Point(oColumnLefts(i), nTop))

                    ElseIf oColumnTypes(i) Is GetType(DataGridViewComboBoxColumn) Then

                        oComboBox.Size = New Size(oColumnWidths(i), nHeight)
                        Dim oBitmap As New Bitmap(oComboBox.Width, oComboBox.Height)
                        oComboBox.DrawToBitmap(oBitmap, New Rectangle(0, 0, oBitmap.Width, oBitmap.Height))
                        e.Graphics.DrawImage(oBitmap, New Point(oColumnLefts(i), nTop))
                        e.Graphics.DrawString(oCell.Value.ToString, oCell.InheritedStyle.Font, New SolidBrush(oCell.InheritedStyle.ForeColor), New RectangleF(oColumnLefts(i) + 1, nTop, oColumnWidths(i) - 16, nHeight), oStringFormatComboBox)

                    ElseIf oColumnTypes(i) Is GetType(DataGridViewImageColumn) Then

                        Dim oCellSize As Rectangle = New Rectangle(oColumnLefts(i), nTop, oColumnWidths(i), nHeight)
                        Dim oImageSize As Size = CType(oCell.Value, Image).Size
                        e.Graphics.DrawImage(oCell.Value, New Rectangle(oColumnLefts(i) + CType(((oCellSize.Width - oImageSize.Width) / 2), Int32), nTop + CType(((oCellSize.Height - oImageSize.Height) / 2), Int32), CType(oCell.Value, Image).Width, CType(oCell.Value, Image).Height))

                    End If

                    e.Graphics.DrawRectangle(Pens.Black, New Rectangle(oColumnLefts(i), nTop, oColumnWidths(i), nHeight))

                    i += 1

                Next

            End If

            nRowPos += 1
            nRowsPerPage += 1

        Loop

        DrawFooter(e, nRowsPerPage)

        e.HasMorePages = False

    End Sub

    Private Sub DrawFooter(ByVal e As System.Drawing.Printing.PrintPageEventArgs, ByVal RowsPerPage As Int32)

        Dim sPageNo As String = nPageNo.ToString + " of " + Math.Ceiling(DataGridView1.Rows.Count / RowsPerPage).ToString

        ' Right Align - User Name
        e.Graphics.DrawString(sUserName, DataGridView1.Font, Brushes.Black, e.MarginBounds.Left + (e.MarginBounds.Width - e.Graphics.MeasureString(sPageNo, DataGridView1.Font, e.MarginBounds.Width).Width), e.MarginBounds.Top + e.MarginBounds.Height + 7)

        ' Left Align - Date/Time
        e.Graphics.DrawString(Now.ToLongDateString + " " + Now.ToShortTimeString, DataGridView1.Font, Brushes.Black, e.MarginBounds.Left, e.MarginBounds.Top + e.MarginBounds.Height + 7)

        ' Center  - Page No. Info
        e.Graphics.DrawString(sPageNo, DataGridView1.Font, Brushes.Black, e.MarginBounds.Left + (e.MarginBounds.Width - e.Graphics.MeasureString(sPageNo, DataGridView1.Font, e.MarginBounds.Width).Width) / 2, e.MarginBounds.Top + e.MarginBounds.Height + 31)

    End Sub
   
   
End Class