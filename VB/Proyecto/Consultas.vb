Public Class Consultas

    Private Sub Consultas_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        Label4.Text = "Usuario : " + usuario + ""
        main()

        Dim Diarios As String
        Dim Conceptos As String
        Dim Departamentos As String
        Dim Centrocostes As String
        Dim Proyectos As String


        comm.CommandText = "select  *  from TablaDiario"

        Dim myReader As DataSet = New DataSet

        datadp.Fill(myReader)

        Dim selectedRowCount As Integer = myReader.Tables(0).Rows.Count

        ComboBox2.Items.Add("")

        For i = 0 To selectedRowCount - 1
            Diarios = myReader.Tables(0).Rows(i)("CodigoDiario") + " - " + myReader.Tables(0).Rows(i)("DescripcionDiario")
            ComboBox2.Items.Add(Diarios)
        Next i

        cnx.Close()

        main()

        comm.CommandText = "select  *  from TablaConcepto"

        Dim myReader2 As DataSet = New DataSet

        datadp.Fill(myReader2)

        Dim selectedRowCount2 As Integer = myReader2.Tables(0).Rows.Count

        ComboBox1.Items.Add("")

        For j = 0 To selectedRowCount2 - 1
            Conceptos = myReader2.Tables(0).Rows(j)("CodigoConcepto") + " - " + myReader2.Tables(0).Rows(j)("DescripcionConcepto")
            ComboBox1.Items.Add(Conceptos)
        Next j

        cnx.Close()

        main()

        comm.CommandText = "select  *  from TablaDepartamento"

        Dim myReader3 As DataSet = New DataSet

        datadp.Fill(myReader3)

        Dim selectedRowCount3 As Integer = myReader3.Tables(0).Rows.Count

        ComboBox3.Items.Add("")

        For k = 0 To selectedRowCount3 - 1
            Departamentos = myReader3.Tables(0).Rows(k)("CodigoDepartamento") + " - " + myReader3.Tables(0).Rows(k)("DescripcionDepartamento")
            ComboBox3.Items.Add(Departamentos)
        Next k

        cnx.Close()

        main()

        comm.CommandText = "select  *  from TablaCoste"

        Dim myReader4 As DataSet = New DataSet

        datadp.Fill(myReader4)

        Dim selectedRowCount4 As Integer = myReader4.Tables(0).Rows.Count

        ComboBox4.Items.Add("")

        For l = 0 To selectedRowCount4 - 1
            Centrocostes = myReader4.Tables(0).Rows(l)("CodigoCoste") + " - " + myReader4.Tables(0).Rows(l)("DescripcionCoste")
            ComboBox4.Items.Add(Centrocostes)
        Next l

        cnx.Close()

        main()

        comm.CommandText = "select  *  from TablaProyecto"

        Dim myReader5 As DataSet = New DataSet

        datadp.Fill(myReader5)

        Dim selectedRowCount5 As Integer = myReader5.Tables(0).Rows.Count

        ComboBox5.Items.Add("")

        For j = 0 To selectedRowCount5 - 1
            Proyectos = myReader5.Tables(0).Rows(j)("CodigoProyecto") + " - " + myReader5.Tables(0).Rows(j)("DescripcionProyecto")
            ComboBox5.Items.Add(Proyectos)
        Next j

        cnx.Close()
    End Sub

    Private Sub Mostrar_Click(sender As System.Object, e As System.EventArgs) Handles Mostrar.Click
        cnx.Close()
        DataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells

        Dim cadena As String
        Dim temporal As String
        Dim nueva As String

        main()

        cadena = "select Asiento, Fecha, NumDocumento, Subcuenta, DH, Total, Diario, Concepto, Departamento, Centrocoste, Proyecto, cliente, IVA from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "'"

        If Not (TextBox3.Text = String.Empty) Then
            temporal = " AND Subcuenta = " & "'" & TextBox3.Text & "'"
            nueva = cadena + temporal
            cadena = nueva
        End If

        If Not (ComboBox2.Text = String.Empty) Then
            temporal = " AND Diario = " & "'" & ComboBox2.Text.Substring(0, 2) & "'"
            nueva = cadena + temporal
            cadena = nueva
        End If

        If Not (ComboBox1.Text = String.Empty) Then
            temporal = " AND Concepto = " & "'" & ComboBox1.Text.Substring(0, 3) & "'"
            nueva = cadena + temporal
            cadena = nueva
        End If

        If Not (ComboBox3.Text = String.Empty) Then
            temporal = " AND Departamento = " & "'" & ComboBox3.Text.Substring(0, 3) & "'"
            nueva = cadena + temporal
            cadena = nueva
        End If

        If Not (ComboBox4.Text = String.Empty) Then
            temporal = " AND Centrocoste = " & "'" & ComboBox4.Text.Substring(0, 3) & "'"
            nueva = cadena + temporal
            cadena = nueva
        End If

        If Not (ComboBox5.Text = String.Empty) Then
            temporal = " AND Proyecto = " & "'" & ComboBox5.Text.Substring(0, 3) & "'"
            nueva = cadena + temporal
            cadena = nueva
        End If

        cadena = cadena + "order by Asiento"
        comm.CommandText = cadena

        Dim myReader As SqlClient.SqlDataReader

        myReader = comm.ExecuteReader()

        Dim DT As New DataTable

        DT.Load(myReader)

        DataGridView1.DataSource = DT

        cnx.Close()

    End Sub

    Private Sub Imprimir_Click_1(sender As System.Object, e As System.EventArgs) Handles Imprimir.Click
        PrintDialog1.Document = PrintDocument1
        PrintDocument1.DefaultPageSettings.Landscape = False
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
    Private Header As String = "Consultas"
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

    Private Sub Borrar_Click(sender As System.Object, e As System.EventArgs) Handles Borrar.Click

        Dim selectedRowCount As Integer = _
            DataGridView1.Rows.GetRowCount(DataGridViewElementStates.Selected)

        If selectedRowCount > 0 Then

            Dim sb As New System.Text.StringBuilder()

            Dim i As Integer
            For i = 0 To selectedRowCount - 1

                sb.Append("Asiento: ")
                sb.Append(DataGridView1.SelectedRows(i).Cells(0).Value.ToString())
                sb.Append(Environment.NewLine)

            Next i

            sb.Append("Total: " + selectedRowCount.ToString())
            sb.Append(" Filas seleccionadas")
            sb.Append(Environment.NewLine)

            If MsgBox(sb.ToString() + "¿ Borrar todas ?", vbOKCancel, "Confirmación") = vbOK Then
                Dim selectedRowCount2 As Integer = _
                    DataGridView1.Rows.GetRowCount(DataGridViewElementStates.Selected)

                If selectedRowCount2 > 0 Then



                    Dim j As Integer
                    For j = 0 To selectedRowCount - 1
                        cnx.Close()
                        main()
                        comm.CommandText = "delete from TablaFacturas where Asiento= " + DataGridView1.SelectedRows(j).Cells(0).Value.ToString() + ""
                        comm.ExecuteNonQuery()
                        cnx.Close()
                        main()
                    Next j
                End If
                Mostrar_Click(Nothing, Nothing)
            End If
        End If

    End Sub

    Private Sub Modificar_Click(sender As System.Object, e As System.EventArgs) Handles Modificar.Click
        Dim selectedRowCount As Integer = _
            DataGridView1.Rows.GetRowCount(DataGridViewElementStates.Selected)

        If selectedRowCount = 1 Then
            Principal.AsientoM = DataGridView1.SelectedRows(0).Cells(0).Value.ToString()
            ApufacM.Show()
            ApufacM.BringToFront()
        Else
            MessageBox.Show("Seleccione una fila.")
        End If
    End Sub

End Class