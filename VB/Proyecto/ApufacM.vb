Public Class ApufacM

    Private Sub ApufacM_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        Asiento.Text = Principal.AsientoM
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


        comm.CommandText = "select  *  from TablaFacturas where Asiento=" + Asiento.Text + ""

        Dim myReader3 As DataSet = New DataSet

        datadp.Fill(myReader3)

        Fecha.Text = myReader3.Tables(0).Rows(0)("Fecha")
        Numdocumento.Text = myReader3.Tables(0).Rows(0)("Numdocumento")
        Debehaber.Text = myReader3.Tables(0).Rows(0)("DH")
        Subcuenta.Text = myReader3.Tables(0).Rows(0)("Subcuenta")

        'If Not (myReader3.Tables(0).Rows(0)("Departamento") = String.Empty) Then
        Departamento.Text = myReader3.Tables(0).Rows(0)("Departamento")
        'End If

        'If Not (myReader3.Tables(0).Rows(0)("Centrocoste") = String.Empty) Then
        Centrocoste.Text = myReader3.Tables(0).Rows(0)("Centrocoste")
        'End If

        'If Not (myReader3.Tables(0).Rows(0)("Proyecto") = String.Empty) Then
        Proyecto.Text = myReader3.Tables(0).Rows(0)("Proyecto")
        'End If

        Cantidad.Value = myReader3.Tables(0).Rows(0)("Total")

        'If Not (myReader3.Tables(0).Rows(0)("Cliente") = String.Empty) Then
        TextBox4.Text = myReader3.Tables(0).Rows(0)("Cliente")
        'End If

        'If Not (myReader3.Tables(0).Rows(0)("IVA") = String.Empty) Then
        Iva.Text = myReader3.Tables(0).Rows(0)("IVA")
        'End If

        Dim Diario1 As String = myReader3.Tables(0).Rows(0)("Diario")
        Dim Concepto1 As String = myReader3.Tables(0).Rows(0)("Concepto")


        cnx.Close()
        main()

        comm.CommandText = "select  *  from TablaDiario where CodigoDiario =" + Diario1 + " "

        Dim myReader5 As DataSet = New DataSet

        datadp.Fill(myReader5)

        Combodiario.SelectedText = myReader5.Tables(0).Rows(0)("CodigoDiario") + " - " + myReader5.Tables(0).Rows(0)("DescripcionDiario")

        cnx.Close()
        main()

        comm.CommandText = "select  *  from TablaConcepto where CodigoConcepto =" + Concepto1 + " "

        Dim myReader6 As DataSet = New DataSet

        datadp.Fill(myReader6)

        Comboconcepto.SelectedText = myReader6.Tables(0).Rows(0)("CodigoConcepto") + " - " + myReader6.Tables(0).Rows(0)("DescripcionConcepto")

        cnx.Close()

    End Sub

    Private Sub Modificar_Click(sender As System.Object, e As System.EventArgs) Handles Modificar.Click
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

                                                If Not (Iva.Text = String.Empty) And Not (IsNumeric(Iva.Text)) Then
                                                    MessageBox.Show("Iva no numérico")
                                                Else
                                                    Dim cadena As String
                                                    cadena = Combodiario.Text.Substring(0, 2)
                                                    Dim cadena2 As String
                                                    cadena2 = Comboconcepto.Text.Substring(0, 3)
                                                    If MsgBox("¿ Modificar Asiento: " + Asiento.Text + "?", vbOKCancel) = vbOK Then
                                                        comm.CommandText = "update TablaFacturas set Fecha=" & "'" & Fecha.Text & "', NumDocumento=" & "'" & Numdocumento.Text & "', DH=" & "'" & Debehaber.Text & "', Subcuenta=" & "'" & Subcuenta.Text & "', Diario=" & "'" & cadena & "', Concepto=" & "'" & cadena2 & "', Departamento=" & "'" & Departamento.Text & "', Centrocoste=" & "'" & Centrocoste.Text & "', Proyecto=" & "'" & Proyecto.Text & "', Cliente=" & "'" & TextBox4.Text & "', IVA=" & "'" & Iva.Text & "', Total=" & "'" & Cantidad.Value.ToString.Replace(",", ".") & "' where Asiento=" & "'" & Asiento.Text & "'"
                                                        comm.ExecuteNonQuery()
                                                        cnx.Close()
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
    End Sub

    Private Sub Debehaber_TextChanged(sender As System.Object, e As System.EventArgs) Handles Debehaber.TextChanged
        If (Debehaber.Text = "h") Then
            Debehaber.Text = "H"
        ElseIf (Debehaber.Text = "d") Then
            Debehaber.Text = "D"
        End If
    End Sub
End Class