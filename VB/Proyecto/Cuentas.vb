
Imports System.Data.SqlClient

Public Class Cuentas
    Dim Fecha = Date.Today

    Private Sub Agregar_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Agregar.Click
        cnx.Close()
        main()

        If (TextBox1.Text.Length <= 4) Then

            Dim aux As String
            Dim copia As String
            copia = TextBox1.Text
            aux = copia.Substring(0, TextBox1.Text.Length - 1)


            comm.CommandText = "select * from TablaCuenta where CodigoCuenta= " & "'" & aux & "'"

            Dim myReader As DataSet = New DataSet

            datadp.Fill(myReader)

            If (TextBox1.Text.Length = 1) Or Not (myReader.Tables(0).Rows.Count = 0) Then

                If IsNumeric(TextBox1.Text) Then
                    If Not (TextBox2.Text = String.Empty) Then

                        comm.CommandText = "select * from TablaCuenta where CodigoCuenta= " & "'" & TextBox1.Text & "'"

                        Dim myReader2 As DataSet = New DataSet
                        datadp.Fill(myReader2)

                        If myReader2.Tables(0).Rows.Count = 0 Then
                            cnx.Close()

                            main()
                            If MsgBox("¿ Insertar: " + TextBox1.Text + " - " + TextBox2.Text + "?", vbOKCancel, "Confirmación") = vbOK Then
                                comm.CommandText = "insert into TablaCuenta values ('" + TextBox1.Text + "','" + TextBox2.Text + "')"
                                comm.ExecuteNonQuery()
                                cnx.Close()

                                main()
                                comm.CommandText = "insert into TablaCuentaCambio values ('" + TextBox1.Text + "','" + TextBox2.Text + "','" + usuario + "','" + Fecha + "','Insertado')"
                                comm.ExecuteNonQuery()
                                cnx.Close()
                                Menupr.Estado.Text = "Insertado: Codigo(" + TextBox1.Text + ")"
                                Listar_Click(Nothing, Nothing)
                            End If
                        Else
                            MessageBox.Show("Código existente.")
                        End If
                    Else
                        MessageBox.Show("Falta Descripción.")
                    End If
                Else
                    MessageBox.Show("Codigo no numérico.")
                End If
            Else
                MessageBox.Show("No existe el nivel anterior.")
            End If
        Else
            MessageBox.Show("Código incorrecto. Debe tener 4 o menos cifras.")
        End If
        cnx.Close()

    End Sub

    Private Sub Borrar_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Borrar.Click
        Dim des As String = ""

        main()
        If TextBox1.Text.Length < 5 Then
            If IsNumeric(TextBox1.Text) Then
                comm.CommandText = "select * from TablaCuenta where CodigoCuenta= " & "'" & TextBox1.Text & "'"

                Dim myReader As DataSet = New DataSet

                datadp.Fill(myReader)

                If myReader.Tables(0).Rows.Count > 0 Then
                    cnx.Close()
                    main()

                    Dim sup As String = TextBox1.Text
                    Dim sup1 As String = TextBox1.Text * 10
                    Dim sup2 As String = sup1 + 9

                    comm.CommandText = "select * from TablaCuenta where CodigoCuenta>= " & "'" & sup1 & "' AND CodigoCuenta<= " & "'" & sup2 & "' "

                    Dim myReader2 As DataSet = New DataSet

                    datadp.Fill(myReader2)

                    If (myReader2.Tables(0).Rows.Count = 0) Then
                        cnx.Close()
                        main()
                        'No existan facturas con subcuenta que comience por este codigo de cuenta

                        Dim codsub1 As String = TextBox1.Text
                        Dim codsub2 As String = codsub1 + 1
                        Dim codsublength As Integer = TextBox1.Text.Length
                        Dim relleno As Integer = 8 - codsublength
                        Dim i As Integer
                        For i = 1 To relleno
                            codsub1 = codsub1 * 10
                            codsub2 = codsub2 * 10
                        Next
                        codsub2 = codsub2 - 1

                        comm.CommandText = "select * from TablaFacturas where Subcuenta>= " & "'" & codsub1 & "' AND Subcuenta<= " & "'" & codsub2 & "' "

                        Dim myReader3 As DataSet = New DataSet

                        datadp.Fill(myReader3)


                        If (myReader3.Tables(0).Rows.Count = 0) Then
                            cnx.Close()
                            main()
                            des = myReader.Tables(0).Rows(0)("DescripcionCuenta")
                            If MsgBox("¿ Borrar: " + TextBox1.Text + "-" + des + "?", vbOKCancel, "Confirmación") = vbOK Then
                                comm.CommandText = "delete from TablaCuenta where CodigoCuenta= " + TextBox1.Text + ""
                                comm.ExecuteNonQuery()
                                cnx.Close()
                                main()
                                comm.CommandText = "insert into TablaCuentaCambio values ('" + TextBox1.Text + "','','" + usuario + "','" + Fecha + "','Borrado')"
                                comm.ExecuteNonQuery()
                                Menupr.Estado.Text = "Borrado: Codigo(" + TextBox1.Text + ")"
                                Listar_Click(Nothing, Nothing)
                            End If
                        Else

                            MessageBox.Show("No puede eliminar un código mientras haya Apuntes/Facturas que lo usen.")

                        End If
                    Else

                        MessageBox.Show("Es necesario eliminar antes los códigos del nivel superior.")

                    End If
                Else

                    MessageBox.Show("Código no existente.")

                End If
            Else
                MessageBox.Show("Código no numérico.")
            End If
        Else
            MessageBox.Show("Código incorrecto. Debe tener 4 o menos cifras.")
        End If

        cnx.Close()

    End Sub


    Private Sub Detallar_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Detallar.Click

        main()

        If TextBox1.Text.Length < 5 Then
            If IsNumeric(TextBox1.Text) Then
                comm.CommandText = "select * from TablaCuentaCambio where CodigoCuenta= " & "'" & TextBox1.Text & "' order by FechaCuenta asc "

                Dim myReader As SqlClient.SqlDataReader

                myReader = comm.ExecuteReader()

                Dim DT As New DataTable

                DT.Load(myReader)

                DataGridView1.DataSource = DT
                DataGridView1.Columns(4).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            Else
                MessageBox.Show("Código no numérico.")
            End If
        Else
            MessageBox.Show("Código incorrecto. Debe tener 4 o menos cifras.")
        End If
        cnx.Close()
    End Sub

    Private Sub Listar_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Listar.Click
        cnx.Close()
        main()
        comm.CommandText = "select CodigoCuenta Código, DescripcionCuenta Descripción from TablaCuenta order by CodigoCuenta"

        Dim myReader As SqlClient.SqlDataReader

        myReader = comm.ExecuteReader()

        Dim DT As New DataTable

        DT.Load(myReader)

        DataGridView1.DataSource = DT

        DataGridView1.Columns(1).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill

        cnx.Close()

    End Sub

    Private Sub Cuentas_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
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


    Private Sub Modificar_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Modificar.Click
        Dim des As String = ""
        cnx.Close()
        main()
        If TextBox1.Text.Length < 5 Then
            If IsNumeric(TextBox1.Text) Then
                If Not (TextBox2.Text = String.Empty) Then
                    comm.CommandText = "select * from TablaCuenta where CodigoCuenta= " & "'" & TextBox1.Text & "'"

                    Dim myReader As DataSet = New DataSet

                    datadp.Fill(myReader)

                    If myReader.Tables(0).Rows.Count > 0 Then
                        cnx.Close()
                        main()
                        des = myReader.Tables(0).Rows(0)("DescripcionCuenta")
                        If MsgBox("¿ Modificar Codigo: " + TextBox1.Text + " " + Chr(13) + "  " + des + " por " + TextBox2.Text + "?", vbOKCancel, "Confirmación") = vbOK Then
                            comm.CommandText = "update TablaCuenta set DescripcionCuenta=" & "'" & TextBox2.Text & "' where codigocuenta=" & "'" & TextBox1.Text & "'"
                            comm.ExecuteNonQuery()
                            cnx.Close()
                            main()
                            comm.CommandText = "insert into TablaCuentaCambio values ('" + TextBox1.Text + "','" + TextBox2.Text + "','" + usuario + "','" + Fecha + "','Modificado')"
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
                MessageBox.Show("Código no numérico.")
            End If
        Else
            MessageBox.Show("Código incorrecto. Debe tener 4 o menos cifras.")
        End If
        cnx.Close()
    End Sub

    Private Sub Imprimir_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Imprimir.Click
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
    Private Header As String = "Cuentas"
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
                oColumnTypes.add(oColumn.GetType)
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