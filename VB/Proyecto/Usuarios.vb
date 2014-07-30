Public Class Usuarios

    
    
    Private Sub CrearPriv_Click(sender As System.Object, e As System.EventArgs) Handles CrearPriv.Click
        main()

        Dim PrivAñAp As String = "False"
        Dim PrivConAp As String = "False"
        Dim PrivBalances As String = "False"
        Dim PrivPresupuestos As String = "False"
        Dim PrivAñCo As String = "False"
        Dim PrivMoCo As String = "False"
        Dim PrivDeCo As String = "False"
        Dim PrivClientes As String = "False"
        Dim PrivEdAp As String = "False"
        Dim PrivUsuarios As String = "False"


        If CheckBox1.Checked = True Then
            PrivAñAp = "True"
        End If

        If CheckBox2.Checked = True Then
            PrivConAp = "True"
        End If

        If CheckBox3.Checked = True Then
            PrivBalances = "True"
        End If

        If CheckBox4.Checked = True Then
            PrivPresupuestos = "True"
        End If

        If CheckBox5.Checked = True Then
            PrivAñCo = "True"
        End If

        If CheckBox6.Checked = True Then
            PrivMoCo = "True"
        End If

        If CheckBox7.Checked = True Then
            PrivDeCo = "True"
        End If

        If CheckBox8.Checked = True Then
            PrivClientes = "True"
        End If

        If CheckBox9.Checked = True Then
            PrivEdAp = "True"
        End If

        If CheckBox10.Checked = True Then
            PrivUsuarios = "True"
        End If

        If Not (TextBox1.Text = String.Empty) And (TextBox1.Text.Length < 255) Then

            comm.CommandText = "select * from TablaPrivilegio where Privilegio= " & "'" & TextBox1.Text & "'"

            Dim myReader As DataSet = New DataSet

            datadp.Fill(myReader)

            If (myReader.Tables(0).Rows.Count = 0) Then
                cnx.Close()

                main()
                comm.CommandText = "insert into TablaPrivilegio values ('" + TextBox1.Text + "','" + PrivAñAp + "','" + PrivConAp + "','" + PrivEdAp + "','" + PrivBalances + "','" + PrivPresupuestos + "','" + PrivAñCo + "','" + PrivMoCo + "','" + PrivDeCo + "','" + PrivClientes + "','" + PrivUsuarios + "')"
                comm.ExecuteNonQuery()
                cnx.Close()
                MessageBox.Show("Creado.")
            Else
                MessageBox.Show("Descripción existente.")
            End If
        Else
            MessageBox.Show("Descripción incorrecta.")
        End If
        cnx.Close()

    End Sub

    Private Sub Usuarios_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        Label18.Text = "Usuario : " + usuario + ""
        main()

        comm.CommandText = "select  *  from TablaPrivilegio"

        Dim myReader As SqlClient.SqlDataReader

        myReader = comm.ExecuteReader()

        Dim DT As New DataTable

        DT.Load(myReader)

        For Each row As DataRow In DT.Rows
            ComboBox1.Items.Add(row("Privilegio"))
        Next

        cnx.Close()
    End Sub

    Private Sub Button2_Click(sender As System.Object, e As System.EventArgs) Handles Button2.Click

        If Not (TextBox2.Text = String.Empty) And (TextBox2.Text.Length < 255) Then

            If Not (TextBox3.Text = String.Empty) And (TextBox2.Text.Length < 11) And (TextBox2.Text.Length > 5) Then

                If ComboBox1.Text = String.Empty Then
                    MessageBox.Show("Privilegios no seleccionados")
                Else
                    comm.CommandText = "select * from Usuarios where Nombre= " & "'" & TextBox2.Text & "'"

                    Dim myReader As DataSet = New DataSet

                    datadp.Fill(myReader)

                    If (myReader.Tables(0).Rows.Count = 0) Then
                        cnx.Close()

                        main()
                        comm.CommandText = "insert into Usuarios values ('" + TextBox2.Text + "','" + TextBox3.Text + "','" + ComboBox1.Text + "')"
                        comm.ExecuteNonQuery()
                        cnx.Close()
                        MessageBox.Show("Creado.")
                    Else
                        MessageBox.Show("Usuario existente.")
                    End If
                End If
            Else
                MessageBox.Show("Contraseña incorrecta. Entre 6 y 10 números")
            End If
            Else
                MessageBox.Show("Usuario incorrecto.")
            End If
            cnx.Close()

    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(sender As System.Object, e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged

        Dim MPrivilegio As String
        Dim MPrivAñAp As String
        Dim MPrivConAp As String
        Dim MPrivEdAp As String
        Dim MPrivBalances As String
        Dim MPrivPresupuestos As String
        Dim MPrivAñCo As String
        Dim MPrivMoCo As String
        Dim MPrivDeCo As String
        Dim MPrivClientes As String
        Dim MPrivUsuarios As String



        comm.CommandText = "select * from TablaPrivilegio where Privilegio= " & "'" & ComboBox1.Text & "'"
        Dim myReader2 As DataSet = New DataSet

        datadp.Fill(myReader2)

        If myReader2.Tables(0).Rows.Count > 0 Then

            MPrivilegio = myReader2.Tables(0).Rows(0)("Privilegio")
            MPrivAñAp = myReader2.Tables(0).Rows(0)("PrivAñAp")
            MPrivConAp = myReader2.Tables(0).Rows(0)("PrivConAp")
            MPrivEdAp = myReader2.Tables(0).Rows(0)("PrivEdAp")
            MPrivBalances = myReader2.Tables(0).Rows(0)("PrivBalances")
            MPrivPresupuestos = myReader2.Tables(0).Rows(0)("PrivPresupuestos")
            MPrivAñCo = myReader2.Tables(0).Rows(0)("PrivAñCo")
            MPrivMoCo = myReader2.Tables(0).Rows(0)("PrivMoCo")
            MPrivDeCo = myReader2.Tables(0).Rows(0)("PrivDeCo")
            MPrivClientes = myReader2.Tables(0).Rows(0)("PrivClientes")
            MPrivUsuarios = myReader2.Tables(0).Rows(0)("PrivUsuarios")

            If MPrivAñAp = True Then
                CheckBox1.Checked = True
            Else
                CheckBox1.Checked = False
            End If

            If MPrivConAp = True Then
                CheckBox2.Checked = True
            Else
                CheckBox2.Checked = False
            End If

            If MPrivBalances = True Then
                CheckBox3.Checked = True
            Else
                CheckBox3.Checked = False
            End If

            If MPrivPresupuestos = True Then
                CheckBox4.Checked = True
            Else
                CheckBox4.Checked = False
            End If

            If MPrivAñCo = True Then
                CheckBox5.Checked = True
            Else
                CheckBox5.Checked = False
            End If

            If MPrivMoCo = True Then
                CheckBox6.Checked = True
            Else
                CheckBox6.Checked = False
            End If

            If MPrivDeCo = True Then
                CheckBox7.Checked = True
            Else
                CheckBox7.Checked = False
            End If

            If MPrivClientes = True Then
                CheckBox8.Checked = True
            Else
                CheckBox8.Checked = False
            End If

            If MPrivEdAp = True Then
                CheckBox9.Checked = True
            Else
                CheckBox9.Checked = False
            End If

            If MPrivUsuarios = True Then
                CheckBox10.Checked = True
            Else
                CheckBox10.Checked = False
            End If

        End If
    End Sub
End Class