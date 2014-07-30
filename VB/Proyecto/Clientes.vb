Public Class Clientes


    Dim Fecha = Date.Today

    Private Sub Añadir_Click(sender As System.Object, e As System.EventArgs) Handles Añadir.Click
        cnx.Close()
        main()
        If Not (Codigo.Text = String.Empty) And (Codigo.Text.Length = 4) And IsNumeric(Codigo.Text) Then
            comm.CommandText = "select * from TablaClientes where Codigo= " & "'" & Codigo.Text & "'"

            Dim myReader As DataSet = New DataSet

            datadp.Fill(myReader)

            If myReader.Tables(0).Rows.Count = 0 Then
                cnx.Close()

                main()
                If Not (Nif.Text = String.Empty) And (Nif.Text.Length < 20) And Valida(Nif.Text) Then

                    comm.CommandText = "select * from TablaClientes where Nif= " & "'" & Nif.Text & "'"
                    datadp.Fill(myReader)

                    If myReader.Tables(0).Rows.Count = 0 Then
                        cnx.Close()
                        main()

                        If Not (Descripcion.Text = String.Empty) And (Descripcion.Text.Length < 255) Then
                            If (Direccion.Text.Length < 255) Then
                                If (Postal.Text.Length < 10) And IsNumeric(Postal.Text) Then
                                    If (Poblacion.Text.Length < 30) Then
                                        If (Pais.Text.Length < 30) Then
                                            If (Telefono1.Text.Length < 30) And IsNumeric(Telefono1.Text) Then
                                                If (Telefono2.Text.Length < 30) And IsNumeric(Telefono2.Text) Then
                                                    If (Correo.Text.Length < 255) Then
                                                        If (Web.Text.Length < 255) Then

                                                            comm.CommandText = "insert into TablaClientes values ('" + Codigo.Text + "','" + Descripcion.Text + "','" + Nif.Text + "','" + Direccion.Text + "','" + Postal.Text + "','" + Poblacion.Text + "','" + Pais.Text + "','" + Telefono1.Text + "','" + Telefono2.Text + "','" + Correo.Text + "','" + Web.Text + "','" + usuario + "','" + Fecha + "')"
                                                            comm.ExecuteNonQuery()
                                                            Menupr.Estado.Text = "Insertado"
                                                            Listar_Click(Nothing, Nothing)

                                                        Else
                                                            MessageBox.Show("Página Web incorrecta.")
                                                        End If
                                                    Else
                                                        MessageBox.Show("Correo incorrecto.")
                                                    End If
                                                Else
                                                    MessageBox.Show("Teléfono 2 incorrecto.")
                                                End If
                                            Else
                                                MessageBox.Show("Teléfono 1 incorrecto.")
                                            End If
                                        Else
                                            MessageBox.Show("País incorrecto.")
                                        End If
                                    Else
                                        MessageBox.Show("Población incorrecta.")
                                    End If
                                Else
                                    MessageBox.Show("Código Postal incorrecto.")
                                End If
                            Else
                                MessageBox.Show("Dirección incorrecta.")
                            End If
                        Else
                            MessageBox.Show("Descripción incorrecta.")
                        End If
                    Else
                        MessageBox.Show("Nif ya existente.")
                    End If
                Else
                    MessageBox.Show("Nif incorrecto.")
                End If
            Else
                MessageBox.Show("Código ya existente.")
            End If
        Else
            MessageBox.Show("Código numérico de cuatro cifras.")
        End If
        cnx.Close()
    End Sub

    Private Sub Buscar_Click(sender As System.Object, e As System.EventArgs) Handles Rellenar.Click

        If Not (Codigo.Text = String.Empty) Then
            cnx.Close()
            main()

            comm.CommandText = "select * from TablaClientes where Codigo= " & "'" & Codigo.Text & "'"

            Dim myReader As DataSet = New DataSet

            datadp.Fill(myReader)

            If myReader.Tables(0).Rows.Count > 0 Then

                Nif.Text = myReader.Tables(0).Rows(0)("Nif")
                Descripcion.Text = myReader.Tables(0).Rows(0)("Descripcion")
                Direccion.Text = myReader.Tables(0).Rows(0)("Direccion")
                Postal.Text = myReader.Tables(0).Rows(0)("Postal")
                Poblacion.Text = myReader.Tables(0).Rows(0)("Poblacion")
                Pais.Text = myReader.Tables(0).Rows(0)("Pais")
                Telefono1.Text = myReader.Tables(0).Rows(0)("Telefono1")
                Telefono2.Text = myReader.Tables(0).Rows(0)("Telefono2")
                Correo.Text = myReader.Tables(0).Rows(0)("Correo")
                Web.Text = myReader.Tables(0).Rows(0)("Web")
            Else
                MessageBox.Show("Código no encontrado.")
            End If
        ElseIf Not (Nif.Text = String.Empty) Then

            cnx.Close()
            main()

            comm.CommandText = "select * from TablaClientes where Nif= " & "'" & Nif.Text & "'"

            Dim myReader As DataSet = New DataSet

            datadp.Fill(myReader)

            If myReader.Tables(0).Rows.Count > 0 Then

                Codigo.Text = myReader.Tables(0).Rows(0)("Codigo")
                Descripcion.Text = myReader.Tables(0).Rows(0)("Descripcion")
                Direccion.Text = myReader.Tables(0).Rows(0)("Direccion")
                Postal.Text = myReader.Tables(0).Rows(0)("Postal")
                Poblacion.Text = myReader.Tables(0).Rows(0)("Poblacion")
                Pais.Text = myReader.Tables(0).Rows(0)("Pais")
                Telefono1.Text = myReader.Tables(0).Rows(0)("Telefono1")
                Telefono2.Text = myReader.Tables(0).Rows(0)("Telefono2")
                Correo.Text = myReader.Tables(0).Rows(0)("Correo")
                Web.Text = myReader.Tables(0).Rows(0)("Web")
            Else
                MessageBox.Show("Nif no encontrado.")
            End If
        Else
            MessageBox.Show("Falta Código o Nif a buscar.")
        End If


    End Sub


    Private Sub Modificar_Click(sender As System.Object, e As System.EventArgs) Handles Modificar.Click

        cnx.Close()
        main()
        If Not (Codigo.Text = String.Empty) And (Codigo.Text.Length < 4) And IsNumeric(Codigo.Text) And Not (Nif.Text = String.Empty) And (Nif.Text.Length < 20) And Valida(Nif.Text) Then

            comm.CommandText = "select * from TablaClientes where Codigo= " & "'" & Codigo.Text & "' And Nif= " & "'" & Nif.Text & "'"

            Dim myReader2 As DataSet = New DataSet

            datadp.Fill(myReader2)

            If Not (myReader2.Tables(0).Rows.Count = 0) Then
                cnx.Close()

                main()


                If Not (Descripcion.Text = String.Empty) And (Descripcion.Text.Length < 255) Then
                    If (Direccion.Text.Length < 255) Then
                        If (Postal.Text.Length < 30) And IsNumeric(Postal.Text) Then
                            If (Poblacion.Text.Length < 30) Then
                                If (Pais.Text.Length < 30) Then
                                    If (Telefono1.Text.Length < 30) And IsNumeric(Telefono1.Text) Then
                                        If (Telefono2.Text.Length < 30) And IsNumeric(Telefono2.Text) Then
                                            If (Correo.Text.Length < 255) Then
                                                If (Web.Text.Length < 255) Then

                                                    If MsgBox("¿ Modificar Codigo: " + Codigo.Text + " con Nif: " + Nif.Text + "?", vbOKCancel, "Confirmación") = vbOK Then
                                                        comm.CommandText = "update TablaClientes set Descripcion=" & "'" & Descripcion.Text & "', Direccion=" & "'" & Direccion.Text & "', Postal=" & "'" & Postal.Text & "',Poblacion=" & "'" & Poblacion.Text & "', Pais=" & "'" & Pais.Text & "', Telefono1=" & "'" & Telefono1.Text & "', Telefono2=" & "'" & Telefono2.Text & "', Web=" & "'" & Web.Text & "',Correo=" & "'" & Correo.Text & "' where codigo=" & "'" & Codigo.Text & "'"
                                                        comm.ExecuteNonQuery()
                                                        Menupr.Estado.Text = "Insertado"
                                                        Listar_Click(Nothing, Nothing)
                                                    End If

                                                Else
                                                    MessageBox.Show("Página Web incorrecta.")
                                                End If
                                            Else
                                                MessageBox.Show("Correo incorrecto.")
                                            End If
                                        Else
                                            MessageBox.Show("Teléfono 2 incorrecto.")
                                        End If
                                    Else
                                        MessageBox.Show("Teléfono 1 incorrecto.")
                                    End If
                                Else
                                    MessageBox.Show("País incorrecto.")
                                End If
                            Else
                                MessageBox.Show("Población incorrecta.")
                            End If
                        Else
                            MessageBox.Show("Código Postal incorrecto.")
                        End If
                    Else
                        MessageBox.Show("Dirección incorrecta.")
                    End If
                Else
                    MessageBox.Show("Descripción incorrecta.")
                End If
            Else
                MessageBox.Show("Ese Código y ese Nif no existen.")
            End If
        Else
            MessageBox.Show("Código no puede ser vacio o mayor de 20 cifras numericas.")
        End If
        cnx.Close()


    End Sub

    Private Sub Borrar_Click(sender As System.Object, e As System.EventArgs) Handles Borrar.Click
        Dim des As String = ""

        If Not (Codigo.Text = String.Empty) Then
            cnx.Close()
            main()

            comm.CommandText = "select * from TablaClientes where Codigo= " & "'" & Codigo.Text & "'"

            Dim myReader As DataSet = New DataSet

            datadp.Fill(myReader)

            If myReader.Tables(0).Rows.Count > 0 Then

                cnx.Close()
                main()
                des = myReader.Tables(0).Rows(0)("Descripcion")
                If MsgBox("¿ Borrar: " + Codigo.Text + "-" + des + "?", vbOKCancel, "Confirmación") = vbOK Then
                    comm.CommandText = "delete from TablaClientes where Codigo= " + Codigo.Text + ""
                    comm.ExecuteNonQuery()
                    Menupr.Estado.Text = "Borrado: Codigo(" + Codigo.Text + ")"
                    Listar_Click(Nothing, Nothing)
                End If

            Else
                MessageBox.Show("Código no encontrado.")
            End If
        ElseIf Not (Nif.Text = String.Empty) Then

            cnx.Close()
            main()

            comm.CommandText = "select * from TablaClientes where Nif= " & "'" & Nif.Text & "'"

            Dim myReader As DataSet = New DataSet

            datadp.Fill(myReader)

            If myReader.Tables(0).Rows.Count > 0 Then

                cnx.Close()
                main()
                des = myReader.Tables(0).Rows(0)("Descripcion")
                If MsgBox("¿ Borrar: " + Nif.Text + "-" + des + "?", vbOKCancel, "Confirmación") = vbOK Then
                    comm.CommandText = "delete from TablaClientes where Nif= " + Nif.Text + ""
                    comm.ExecuteNonQuery()
                    Menupr.Estado.Text = "Borrado: Nif(" + Nif.Text + ")"
                    Listar_Click(Nothing, Nothing)
                End If

            Else
                MessageBox.Show("Nif no encontrado.")
            End If
        Else
            MessageBox.Show("Falta Código o Nif a buscar.")
        End If

    End Sub

    Private Sub Listar_Click(sender As System.Object, e As System.EventArgs)
        cnx.Close()
        main()
        comm.CommandText = "select Codigo, Descripcion, Nif, Direccion, Postal, Poblacion, Pais, Telefono1, Telefono2, Correo, Web from TablaClientes"

        Dim myReader As SqlClient.SqlDataReader

        myReader = comm.ExecuteReader()

        Dim DT As New DataTable

        DT.Load(myReader)

        DataGridView1.DataSource = DT

        cnx.Close()
    End Sub

    Private Sub Clientes_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        Label11.Text = "Usuario : " + usuario + ""
        Listar_Click(Nothing, Nothing)

        cnx.Close()
        main()

        comm.CommandText = "select codigo from TablaClientes order by codigo desc"

        Dim myReader As SqlClient.SqlDataReader

        myReader = comm.ExecuteReader()

        Dim DT As New DataTable

        DT.Load(myReader)

        Dim Nuevo As String

        Nuevo = 0

        Nuevo = DT.Rows(0)("Codigo")
        Nuevo = Nuevo + 1
        For i = 1 To (4 - Nuevo.Length())
            Nuevo = 0 & Nuevo
        Next
        Codigo.Text = Nuevo
        cnx.Close()
    End Sub


    Public Function Valida(TestString As String) As Boolean

        Dim sTemp As String
        Dim iLen As Integer
        Dim iCtr As Integer
        Dim sChar As String
        Valida = False

        sTemp = TestString
        iLen = Len(sTemp)
        If iLen > 0 Then
            For iCtr = 1 To iLen
                sChar = Mid(sTemp, iCtr, 1)
                If Not sChar Like "[0-9A-Za-z]" Then Exit Function
            Next

            Valida = True
        End If

    End Function

End Class
 