Public Class Principal

    Public TPrivilegio As String
    Public TPrivAñAp As String
    Public TPrivConAp As String
    Public TPrivEdAp As String
    Public TPrivBalances As String
    Public TPrivPresupuestos As String
    Public TPrivAñCo As String
    Public TPrivMoCo As String
    Public TPrivDeCo As String
    Public TPrivClientes As String
    Public TPrivUsuarios As String

    Public AsientoM As String

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        
        comm.CommandText = "select * from Usuarios where Nombre= " & "'" & TextBox1.Text & "' AND Contraseña=" & "'" & TextBox2.Text & "'"

        Dim myReader As DataSet = New DataSet

        datadp.Fill(myReader)

        If myReader.Tables(0).Rows.Count > 0 Then
            usuario = myReader.Tables(0).Rows(0)("Nombre")
            priv = myReader.Tables(0).Rows(0)("Privilegios")
            cnx.Close()

            main()

            comm.CommandText = "select * from TablaPrivilegio where Privilegio= " & "'" & priv & "'"
            Dim myReader2 As DataSet = New DataSet

            datadp.Fill(myReader2)

            If myReader2.Tables(0).Rows.Count > 0 Then

                TPrivilegio = myReader2.Tables(0).Rows(0)("Privilegio")
                TPrivAñAp = myReader2.Tables(0).Rows(0)("PrivAñAp")
                TPrivConAp = myReader2.Tables(0).Rows(0)("PrivConAp")
                TPrivEdAp = myReader2.Tables(0).Rows(0)("PrivEdAp")
                TPrivBalances = myReader2.Tables(0).Rows(0)("PrivBalances")
                TPrivPresupuestos = myReader2.Tables(0).Rows(0)("PrivPresupuestos")
                TPrivAñCo = myReader2.Tables(0).Rows(0)("PrivAñCo")
                TPrivMoCo = myReader2.Tables(0).Rows(0)("PrivMoCo")
                TPrivDeCo = myReader2.Tables(0).Rows(0)("PrivDeCo")
                TPrivClientes = myReader2.Tables(0).Rows(0)("PrivClientes")
                TPrivUsuarios = myReader2.Tables(0).Rows(0)("PrivUsuarios")

                Me.Hide()
                Menupr.Show()
                cnx.Close()
            Else
                MessageBox.Show("Privilegio no existe.")
            End If
        Else
            MessageBox.Show("Usuario y/o contraseña incorrecta/s.")
        End If
    End Sub

    Private Sub Principal_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        main()
    End Sub
    
End Class