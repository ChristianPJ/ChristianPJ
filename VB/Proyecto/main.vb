Public Module inicio
    Public cnx As SqlClient.SqlConnection = New SqlClient.SqlConnection
    Public comm As SqlClient.SqlCommand = New SqlClient.SqlCommand
    Public datadp As SqlClient.SqlDataAdapter
    Public usuario As String = ""
    Public priv As String = ""

    Public Sub main()
        cnx.ConnectionString = "Data Source=CHRISTIAN;Initial Catalog=proyecto;Integrated Security=True"
        cnx.Open()
        comm.Connection = cnx
        datadp = New SqlClient.SqlDataAdapter(comm)
    End Sub
End Module
