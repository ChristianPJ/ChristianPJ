Public Class Balances

    
    Private Sub Mostrar_Click(sender As System.Object, e As System.EventArgs) Handles Mostrar.Click
        cnx.Close()
        If (Nivel1.Checked = True) Then

            main()
            comm.CommandText = "SELECT T1.Código, T2.DescripcionCuenta Descripción, T1.Debe, T1.Haber, T1.Saldo from (select round(subcuenta/10000000,0) Código, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by round(subcuenta/10000000,0)) T1 LEFT JOIN TablaCuenta T2 ON T2.CodigoCuenta=T1.Código"
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(4).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        ElseIf (Nivel2.Checked = True) Then

            main()
            comm.CommandText = "SELECT T1.Código, T2.DescripcionCuenta Descripción, T1.Debe, T1.Haber, T1.Saldo from (select round(subcuenta/1000000,0) Código, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by round(subcuenta/1000000,0)) T1 LEFT JOIN TablaCuenta T2 ON T2.CodigoCuenta=T1.Código"
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(4).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        ElseIf (Nivel3.Checked = True) Then

            main()
            comm.CommandText = "SELECT T1.Código, T2.DescripcionCuenta Descripción, T1.Debe, T1.Haber, T1.Saldo from (select round(subcuenta/100000,0) Código, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by round(subcuenta/100000,0)) T1 LEFT JOIN TablaCuenta T2 ON T2.CodigoCuenta=T1.Código"
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(4).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        ElseIf (Nivel4.Checked = True) Then

            main()
            comm.CommandText = "select subcuenta Código,ts.DescripcionSubcuenta Descripción, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas left join TablaSubcuenta ts on ts.CodigoSubcuenta=TablaFacturas.subcuenta where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by subcuenta, ts.DescripcionSubcuenta order by subcuenta "
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(4).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        Else

            MessageBox.Show("Marca opcion")

        End If
        For Each Row As DataGridViewRow In DataGridView1.Rows

            If Row.Cells("Saldo").Value < 0 Then
                DataGridView1.Item(4, Row.Index).Style.ForeColor = Color.Red
            End If

        Next
       
    End Sub
   
    
    Private Sub Balances_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        Label4.Text = "Usuario : " + usuario + ""
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
    Private Header As String = "Balances"
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

    Private Sub DataGridView1_CellContentClick(sender As System.Object, e As System.Windows.Forms.DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick
        For Each Row As DataGridViewRow In DataGridView1.Rows

            If Row.Cells("Saldo").Value < 0 Then
                DataGridView1.Item(4, Row.Index).Style.ForeColor = Color.Red
            End If

        Next
    End Sub
    Private Sub DataGridView1_Change(sender As System.Object, e As System.Windows.Forms.DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick
        For Each Row As DataGridViewRow In DataGridView1.Rows

            If Row.Cells("Saldo").Value < 0 Then
                DataGridView1.Item(4, Row.Index).Style.ForeColor = Color.Red
            End If

        Next
    End Sub
    Private Sub DataGridView_CellContentDoubleClick(sender As System.Object, e As System.Windows.Forms.DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick
        For Each Row As DataGridViewRow In DataGridView1.Rows

            If Row.Cells("Saldo").Value < 0 Then
                DataGridView1.Item(4, Row.Index).Style.ForeColor = Color.Red
            End If

        Next
    End Sub
End Class