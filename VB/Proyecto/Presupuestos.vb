Public Class Presupuestos

    Dim Fecha = Date.Today

    Private Sub Mostrar_Click(sender As System.Object, e As System.EventArgs) Handles Mostrar.Click
        cnx.Close()
        If (Nivel1.Checked = True) Then

            main()
            comm.CommandText = "SELECT T1.Código Código, T2.DescripcionCuenta Descripción, T1.Debe, T1.Haber, T1.Saldo, T1.DebePre, T1.HaberPre, T1.SaldoPre, T1.Diferencia from (select ISNULL(t1.Codigo,t2.CodigoPre) Código, t1.Debe, t1.Haber, t1.Saldo, t2.DebePre, t2.HaberPre, t2.SaldoPre, ISNULL(Saldo,0)+ISNULL((SaldoPre*-1),0) Diferencia from (select round(subcuenta/10000000,0) Codigo, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by round(subcuenta/10000000,0)) t1 full join (select round(CodigoPre/10000000,0) CodigoPre, sum(DebePre) DebePre, sum(HaberPre) HaberPre, sum(DebePre+(HaberPre*-1)) SaldoPre from TablaPresupuestos where FechaPre >= " & "'" & Fecha1.Value & "' AND FechaPre <= " & "'" & Fecha2.Value & "' group by round(CodigoPre/10000000,0)) t2 on t2.CodigoPre=t1.Codigo) T1 LEFT JOIN TablaCuenta T2 ON T2.CodigoCuenta=T1.Código"
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.ColumnHeader
            DataGridView1.Columns(8).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        ElseIf (Nivel2.Checked = True) Then

            main()
            comm.CommandText = "SELECT T1.Código Código, T2.DescripcionCuenta Descripción, T1.Debe, T1.Haber, T1.Saldo, T1.DebePre, T1.HaberPre, T1.SaldoPre, T1.Diferencia from (select ISNULL(t1.Codigo,t2.CodigoPre) Código, t1.Debe, t1.Haber, t1.Saldo, t2.DebePre, t2.HaberPre, t2.SaldoPre, ISNULL(Saldo,0)+ISNULL((SaldoPre*-1),0) Diferencia from (select round(subcuenta/1000000,0) Codigo, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by round(subcuenta/1000000,0)) t1 full join (select round(CodigoPre/1000000,0) CodigoPre, sum(DebePre) DebePre, sum(HaberPre) HaberPre, sum(DebePre+(HaberPre*-1)) SaldoPre from TablaPresupuestos where FechaPre >= " & "'" & Fecha1.Value & "' AND FechaPre <= " & "'" & Fecha2.Value & "' group by round(CodigoPre/1000000,0)) t2 on t2.CodigoPre=t1.Codigo) T1 LEFT JOIN TablaCuenta T2 ON T2.CodigoCuenta=T1.Código"
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.ColumnHeader
            DataGridView1.Columns(8).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        ElseIf (Nivel3.Checked = True) Then

            main()
            comm.CommandText = "SELECT T1.Código Código, T2.DescripcionCuenta Descripción, T1.Debe, T1.Haber, T1.Saldo, T1.DebePre, T1.HaberPre, T1.SaldoPre, T1.Diferencia from (select ISNULL(t1.Codigo,t2.CodigoPre) Código, t1.Debe, t1.Haber, t1.Saldo, t2.DebePre, t2.HaberPre, t2.SaldoPre, ISNULL(Saldo,0)+ISNULL((SaldoPre*-1),0) Diferencia from (select round(subcuenta/100000,0) Codigo, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by round(subcuenta/100000,0)) t1 full join (select round(CodigoPre/100000,0) CodigoPre, sum(DebePre) DebePre, sum(HaberPre) HaberPre, sum(DebePre+(HaberPre*-1)) SaldoPre from TablaPresupuestos where FechaPre >= " & "'" & Fecha1.Value & "' AND FechaPre <= " & "'" & Fecha2.Value & "' group by round(CodigoPre/100000,0)) t2 on t2.CodigoPre=t1.Codigo) T1 LEFT JOIN TablaCuenta T2 ON T2.CodigoCuenta=T1.Código"
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.ColumnHeader
            DataGridView1.Columns(8).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        ElseIf (Nivel4.Checked = True) Then

            main()
            comm.CommandText = "SELECT T1.Código Código, T2.DescripcionSubcuenta Descripción, T1.Debe, T1.Haber, T1.Saldo, T1.DebePre, T1.HaberPre, T1.SaldoPre, T1.Diferencia from (select ISNULL(t1.Codigo,t2.CodigoPre) Código, t1.Debe, t1.Haber, t1.Saldo, t2.DebePre, t2.HaberPre, t2.SaldoPre, ISNULL(Saldo,0)+ISNULL((SaldoPre*-1),0) Diferencia from (select subcuenta Codigo, sum(case when DH='D' then total else 0 end) as Debe, sum(case when DH='H' then total else 0 end) as Haber,sum(case when DH='D' then total else total*-1 end) as Saldo from TablaFacturas where Fecha >= " & "'" & Fecha1.Value & "' AND Fecha <= " & "'" & Fecha2.Value & "' group by subcuenta) t1 full join (select CodigoPre, sum(DebePre) DebePre, sum(HaberPre) HaberPre, sum(DebePre+(HaberPre*-1)) SaldoPre from TablaPresupuestos where FechaPre >= " & "'" & Fecha1.Value & "' AND FechaPre <= " & "'" & Fecha2.Value & "' group by CodigoPre) t2 on t2.CodigoPre=t1.Codigo) T1 LEFT JOIN TablaSubcuenta T2 ON T2.CodigoSubcuenta=T1.Código"
            Dim myReader As SqlClient.SqlDataReader
            myReader = comm.ExecuteReader()
            Dim DT As New DataTable
            DT.Load(myReader)
            DataGridView1.DataSource = DT
            DataGridView1.Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.ColumnHeader
            DataGridView1.Columns(8).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
            cnx.Close()

        Else

            MessageBox.Show("Marca opcion")

        End If

        For Each Row As DataGridViewRow In DataGridView1.Rows

            If Row.Cells("Diferencia").Value < 0 Then
                DataGridView1.Item(8, Row.Index).Style.ForeColor = Color.Red
            End If

        Next
    End Sub

    Private Sub Presupuestos_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        Label4.Text = "Usuario : " + usuario + ""

        Fecha3.Format = DateTimePickerFormat.Custom
        Fecha3.CustomFormat = "MM/yyyy"

        Listar_Click(Nothing, Nothing)

        Fecha1.Value = Today.Date

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
    Private Header As String = "Presupuestos"
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

    Private Sub Añadir_Click(sender As System.Object, e As System.EventArgs) Handles Añadir.Click

        Fecha3.Value = New Date(Fecha3.Value.Year, Fecha3.Value.Month, 1)

        comm.CommandText = "select * from TablaSubcuenta where CodigoSubcuenta= " & "'" & TextBox1.Text & "'"

        Dim myReader As DataSet = New DataSet

        datadp.Fill(myReader)

        If Not (myReader.Tables(0).Rows.Count = 0) Then
            cnx.Close()
            main()

            comm.CommandText = "select * from TablaPresupuestos where CodigoPre= " & "'" & TextBox1.Text & "' AND FechaPre=" & "'" & Fecha3.Value & "' "

            Dim myReader2 As DataSet = New DataSet

            datadp.Fill(myReader2)

            If myReader2.Tables(0).Rows.Count = 0 Then
                cnx.Close()
                main()
                If MsgBox("¿ Insertar: " + TextBox1.Text + " Fecha: " + Fecha3.Value + " Debe: " + Debe.Text + " Haber: " + Haber.Text + "?", vbOKCancel, "Confirmación") = vbOK Then
                    comm.CommandText = "insert into TablaPresupuestos values ('" + TextBox1.Text + "','" + Fecha3.Value.ToString("yyyy-MM-dd") + "', " & Debe.Value.ToString.Replace(",", ".") & " ," & Haber.Value.ToString.Replace(",", ".") & " ,'" + usuario + "','" + Fecha + "')"
                    comm.ExecuteNonQuery()
                    cnx.Close()
                    MessageBox.Show("Presupuesto Agregado.")
                End If

            Else
                cnx.Close()
                main()
                If MsgBox("Ese presupuesto ya existe. ¿ Actualizar: " + TextBox1.Text + " Debe: " + Debe.Text + " Haber: " + Haber.Text + " Fecha: " + Fecha3.Value + "?", vbOKCancel, "Confirmación") = vbOK Then
                    comm.CommandText = "update TablaPresupuestos set DebePre= " & Debe.Value.ToString.Replace(",", ".") & ",HaberPre= " & Haber.Value.ToString.Replace(",", ".") & ", UsuarioPre='" + usuario + "', FechaCambioPre='" + Fecha + "' where CodigoPre=" + TextBox1.Text + " AND FechaPre='" + Fecha3.Value.ToString("yyyy-MM-dd") + "'"
                    comm.ExecuteNonQuery()
                    cnx.Close()
                    MessageBox.Show("Presupuesto Actualizado.")
                End If

            End If
        Else
            MessageBox.Show("Código Subcuenta no existe.")
        End If
        cnx.Close()
    End Sub

    

    Private Sub Listar_Click(sender As System.Object, e As System.EventArgs)
        Label4.Text = "Usuario : " + usuario + ""
    End Sub

End Class

