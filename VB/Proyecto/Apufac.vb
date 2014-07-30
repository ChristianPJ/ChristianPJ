Imports System.Data.SqlClient

Public Class Apufac

    Dim Usuario As String = "Christian"
    Dim Total As Decimal
    Private Sub CheckBox1_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CheckBox1.CheckedChanged
        If CheckBox1.Checked = True Then
            TextBox4.Enabled = True
            Iva.Enabled = True
        Else
            TextBox4.Enabled = False
            Iva.Enabled = False

        End If
    End Sub


    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        cnx.Close()
        main()

        'Subcuenta
        comm.CommandText = "select * from TablaSubcuenta where CodigoSubcuenta= " & "'" & Subcuenta.Text & "'"
        Dim myReader As DataSet = New DataSet
        datadp.Fill(myReader)

        If (myReader.Tables(0).Rows.Count = 0) Then
            MessageBox.Show("Código de Subcuenta no existente.")
        Else

            cnx.Close()
            main()
            myReader.Tables(0).Clear()

            'Departamento
            comm.CommandText = "select * from TablaDepartamento where CodigoDepartamento= " & "'" & Departamento.Text & "'"
            datadp.Fill(myReader)

            If Not (Departamento.Text = String.Empty) And (myReader.Tables(0).Rows.Count = 0) Then
                MessageBox.Show("Código de Departamento no existente.")
            Else

                cnx.Close()
                main()
                myReader.Tables(0).Clear()

                'Centro de Coste
                comm.CommandText = "select * from TablaCoste where CodigoCoste= " & "'" & Centrocoste.Text & "'"
                datadp.Fill(myReader)

                If Not (Centrocoste.Text = String.Empty) And (myReader.Tables(0).Rows.Count = 0) Then
                    MessageBox.Show("Código de Centro de Coste no existente.")
                Else

                    cnx.Close()
                    main()
                    myReader.Tables(0).Clear()

                    'Proyecto
                    comm.CommandText = "select * from TablaProyecto where CodigoProyecto= " & "'" & Proyecto.Text & "'"
                    datadp.Fill(myReader)

                    If Not (Proyecto.Text = String.Empty) And (myReader.Tables(0).Rows.Count = 0) Then
                        MessageBox.Show("Código de Proyecto no existente.")
                    Else
                        cnx.Close()
                        main()

                        If Not (IsNumeric(Numdocumento.Text)) And (Numdocumento.Text.Length > 250) Then
                            MessageBox.Show("Código incorrecto. Nº de documento debe ser númerico.")
                        Else

                            If Not (Debehaber.Text = "D") And Not (Debehaber.Text = "H") Then
                                MessageBox.Show("Código incorrecto. Solo se acepta 'H' o 'D'")
                            Else

                                If Combodiario.Text = String.Empty Then
                                    MessageBox.Show("Diario no seleccionado")
                                Else

                                    If Comboconcepto.Text = String.Empty Then
                                        MessageBox.Show("Concepto no seleccionado")
                                    Else

                                        If Cantidad.Text = String.Empty Then
                                            MessageBox.Show("Falta cantidad")
                                        Else

                                            'Clientes
                                            comm.CommandText = "select * from TablaClientes where Codigo= " & "'" & TextBox4.Text & "'"
                                            datadp.Fill(myReader)

                                            If Not (TextBox4.Text = String.Empty) And (myReader.Tables(0).Rows.Count = 0) Then
                                                MessageBox.Show("Código de Clientes no existente.")
                                            Else

                                                cnx.Close()
                                                main()
                                                myReader.Tables(0).Clear()

                                                If (CheckBox1.Checked = True) And Not (IsNumeric(Iva.Text)) Then
                                                    MessageBox.Show("Iva no numérico")
                                                Else
                                                    Dim cadena As String
                                                    cadena = Combodiario.Text.Substring(0, 2)
                                                    Dim cadena2 As String
                                                    cadena2 = Comboconcepto.Text.Substring(0, 3)
                                                    comm.CommandText = "insert into Temporal values ('" + Asiento.Text + "','" + Fecha.Value + "','" + Numdocumento.Text + "','" + Debehaber.Text + "','" + Subcuenta.Text + "','" + cadena + "','" + cadena2 + "','" + Departamento.Text + "','" + Centrocoste.Text + "','" + Proyecto.Text + "','" + TextBox4.Text + "','" + Iva.Text + "'," + Cantidad.Value.ToString.Replace(",", ".") + ",'" + Usuario + "')"
                                                    comm.ExecuteNonQuery()
                                                    Menupr.Estado.Text = "Insertado"

                                                    ' Incrementar Asiento
                                                    cnx.Close()

                                                    main()

                                                    comm.CommandText = "select  *  from Asiento"

                                                    Dim myReader3 As SqlClient.SqlDataReader

                                                    myReader3 = comm.ExecuteReader()

                                                    Dim DT3 As New DataTable

                                                    DT3.Load(myReader3)

                                                    Asiento.Text = DT3.Rows(0)("Asiento")

                                                    cnx.Close()

                                                    Dim Nuevo As String

                                                    Nuevo = Asiento.Text + 1

                                                    main()

                                                    comm.CommandText = "update Asiento set Asiento=" & "'" & Nuevo & "' where Asiento=" & "'" & Asiento.Text & "'"

                                                    comm.ExecuteNonQuery()

                                                    cnx.Close()
                                                    main()

                                                    comm.CommandText = "select Asiento, Fecha, NumDocumento, DH, Subcuenta, Diario, Concepto, Departamento, Centrocoste, Proyecto, Cliente, IVA, Total  from Temporal"
                                                    Dim myReader2 As SqlClient.SqlDataReader

                                                    myReader2 = comm.ExecuteReader()

                                                    Dim DT As New DataTable

                                                    DT.Load(myReader2)

                                                    DataGridView1.DataSource = DT

                                                    If (Debehaber.Text = "D") Then
                                                        Total = Total + Decimal.Parse(Cantidad.Text)
                                                        Sumatotal.Text = Total
                                                    ElseIf (Debehaber.Text = "H") Then
                                                        Total = Total - Decimal.Parse(Cantidad.Text)
                                                        Sumatotal.Text = Total
                                                    End If
                                                End If
                                            End If
                                        End If
                                    End If
                                End If
                            End If
                        End If
                    End If
                End If
            End If
        End If
        cnx.Close()

    End Sub


    Private Sub Apufac_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        cnx.Close()

        Label16.Text = "Usuario : " + Usuario + ""

        main()

        comm.CommandText = "Delete from Temporal"

        comm.ExecuteNonQuery()

        cnx.Close()

        main()

        Dim Diarios As String
        Dim Conceptos As String

        comm.CommandText = "select  *  from TablaDiario"

        Dim myReader As DataSet = New DataSet

        datadp.Fill(myReader)

        Dim selectedRowCount As Integer = myReader.Tables(0).Rows.Count

        For i = 0 To selectedRowCount - 1
            Diarios = myReader.Tables(0).Rows(i)("CodigoDiario") + " - " + myReader.Tables(0).Rows(i)("DescripcionDiario")
            Combodiario.Items.Add(Diarios)
        Next i

        cnx.Close()

        main()

        comm.CommandText = "select  *  from TablaConcepto"

        Dim myReader2 As DataSet = New DataSet

        datadp.Fill(myReader2)

        Dim selectedRowCount2 As Integer = myReader2.Tables(0).Rows.Count

        For j = 0 To selectedRowCount2 - 1
            Conceptos = myReader2.Tables(0).Rows(j)("CodigoConcepto") + " - " + myReader2.Tables(0).Rows(j)("DescripcionConcepto")
            Comboconcepto.Items.Add(Conceptos)
        Next j

        cnx.Close()

        main()

        comm.CommandText = "select  *  from Asiento"

        Dim myReader3 As SqlClient.SqlDataReader

        myReader3 = comm.ExecuteReader()

        Dim DT3 As New DataTable

        DT3.Load(myReader3)

        Asiento.Text = DT3.Rows(0)("Asiento")

        cnx.Close()

        Dim Nuevo As Integer

        Nuevo = Asiento.Text + 1

        main()

        comm.CommandText = "update Asiento set Asiento=" & "'" & Nuevo & "' where Asiento=" & "'" & Asiento.Text & "'"

        comm.ExecuteNonQuery()

        cnx.Close()

    End Sub

    Private Sub Finalizar_Click(sender As System.Object, e As System.EventArgs) Handles Finalizar.Click
        Dim suma As Decimal

        main()

        comm.CommandText = "select  *  from Temporal"

        Dim myReader2 As SqlClient.SqlDataReader

        myReader2 = comm.ExecuteReader()

        Dim DT2 As New DataTable

        DT2.Load(myReader2)

        For Each row2 As DataRow In DT2.Rows
            If (row2("DH") = "D") Then
                suma = suma + row2("Total")
            ElseIf (row2("DH") = "H") Then
                suma = suma - row2("Total")
            End If
        Next

        cnx.Close()
        main()

        comm.CommandText = "select  *  from Temporal"

        Dim myReader3 As SqlClient.SqlDataReader

        myReader3 = comm.ExecuteReader()

        Dim DT3 As New DataTable

        DT3.Load(myReader3)

        If (suma = 0) Then

            For Each row3 As DataRow In DT3.Rows
                comm.CommandText = "insert into TablaFacturas values ('" + row3("Asiento").ToString + "','" + row3("Fecha") + "','" + row3("NumDocumento") + "','" + row3("DH") + "','" + row3("Subcuenta") + "','" + row3("Diario") + "','" + row3("Concepto") + "','" + row3("Departamento") + "','" + row3("Centrocoste") + "','" + row3("Proyecto") + "','" + row3("Cliente") + "','" + row3("IVA") + "'," & row3("Total").ToString.Replace(",", ".") & ",'" + row3("Usuario") + "')"
                comm.ExecuteNonQuery()
            Next
            MessageBox.Show("Apuntes/Facturas añadidos con éxito.")
            cnx.Close()
            main()

            comm.CommandText = "Delete from Temporal"

            comm.ExecuteNonQuery()

        Else
            If MsgBox("Suma distinta de cero. ¿Agregar apuntes / facturas? ", vbOKCancel, "Confirmación") = vbOK Then

                For Each row3 As DataRow In DT3.Rows
                    comm.CommandText = "insert into TablaFacturas values ('" + row3("Asiento").ToString + "','" + row3("Fecha") + "','" + row3("NumDocumento") + "','" + row3("DH") + "','" + row3("Subcuenta") + "','" + row3("Diario") + "','" + row3("Concepto") + "','" + row3("Departamento") + "','" + row3("Centrocoste") + "','" + row3("Proyecto") + "','" + row3("Cliente") + "','" + row3("IVA") + "'," & row3("Total").ToString.Replace(",", ".") & ",'" + row3("Usuario") + "')"
                    comm.ExecuteNonQuery()
                Next
                MessageBox.Show("Apuntes/Facturas añadidos con éxito.")
                cnx.Close()
                main()

                comm.CommandText = "Delete from Temporal"

                comm.ExecuteNonQuery()
            End If
        End If
        cnx.Close()
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
    Private Header As String = "Facturas Temporales"
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

    Private Sub Debehaber_TextChanged(sender As System.Object, e As System.EventArgs) Handles Debehaber.TextChanged
        If (Debehaber.Text = "h") Then
            Debehaber.Text = "H"
        ElseIf (Debehaber.Text = "d") Then
            Debehaber.Text = "D"
        End If
    End Sub
End Class