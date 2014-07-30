Imports System.Windows.Forms

Public Class Menupr

    Private Sub ShowNewForm(ByVal sender As Object, ByVal e As EventArgs)
        ' Create a new instance of the child form.
        Dim ChildForm As New System.Windows.Forms.Form
        ' Make it a child of this MDI form before showing it.
        ChildForm.MdiParent = Me

        m_ChildFormNumber += 1
        ChildForm.Text = "Window " & m_ChildFormNumber

        ChildForm.Show()
    End Sub

    Private Sub OpenFile(ByVal sender As Object, ByVal e As EventArgs)
        Dim OpenFileDialog As New OpenFileDialog
        OpenFileDialog.InitialDirectory = My.Computer.FileSystem.SpecialDirectories.MyDocuments
        OpenFileDialog.Filter = "Text Files (*.txt)|*.txt|All Files (*.*)|*.*"
        If (OpenFileDialog.ShowDialog(Me) = System.Windows.Forms.DialogResult.OK) Then
            Dim FileName As String = OpenFileDialog.FileName
            ' TODO: Add code here to open the file.
        End If
    End Sub

    Private Sub SaveAsToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        Dim SaveFileDialog As New SaveFileDialog
        SaveFileDialog.InitialDirectory = My.Computer.FileSystem.SpecialDirectories.MyDocuments
        SaveFileDialog.Filter = "Text Files (*.txt)|*.txt|All Files (*.*)|*.*"

        If (SaveFileDialog.ShowDialog(Me) = System.Windows.Forms.DialogResult.OK) Then
            Dim FileName As String = SaveFileDialog.FileName
            ' TODO: Add code here to save the current contents of the form to a file.
        End If
    End Sub


    Private Sub ExitToolsStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        Me.Close()
    End Sub

    Private Sub CutToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        ' Use My.Computer.Clipboard to insert the selected text or images into the clipboard
    End Sub

    Private Sub CopyToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        ' Use My.Computer.Clipboard to insert the selected text or images into the clipboard
    End Sub

    Private Sub PasteToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        'Use My.Computer.Clipboard.GetText() or My.Computer.Clipboard.GetData to retrieve information from the clipboard.
    End Sub

    Private Sub CascadeToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        Me.LayoutMdi(MdiLayout.Cascade)
    End Sub

    Private Sub TileVerticalToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        Me.LayoutMdi(MdiLayout.TileVertical)
    End Sub

    Private Sub TileHorizontalToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        Me.LayoutMdi(MdiLayout.TileHorizontal)
    End Sub

    Private Sub ArrangeIconsToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        Me.LayoutMdi(MdiLayout.ArrangeIcons)
    End Sub

    Private Sub CloseAllToolStripMenuItem_Click(ByVal sender As Object, ByVal e As EventArgs)
        ' Close all child forms of the parent.
        For Each ChildForm As Form In Me.MdiChildren
            ChildForm.Close()
        Next
    End Sub

    Private m_ChildFormNumber As Integer

    Private Sub DepartamentosToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles DepartamentosToolStripMenuItem.Click
        Departamentos.MdiParent = Me
        Departamentos.Show()
        Departamentos.BringToFront()
    End Sub

    Private Sub CentrosDeCosteToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CentrosDeCosteToolStripMenuItem.Click
        CentrosdeCoste.MdiParent = Me
        CentrosdeCoste.Show()
        CentrosdeCoste.BringToFront()
    End Sub

    Private Sub ProyectosToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ProyectosToolStripMenuItem.Click
        Proyectos.MdiParent = Me
        Proyectos.Show()
        Proyectos.BringToFront()
    End Sub

    Private Sub PresupuestosToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles PresupuestosToolStripMenuItem.Click
        Presupuestos.MdiParent = Me
        Presupuestos.Show()
        Presupuestos.BringToFront()
    End Sub

    Private Sub ApuntesFacturasToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ApuntesFacturasToolStripMenuItem.Click
        Apufac.MdiParent = Me
        Apufac.Show()
        Apufac.BringToFront()
    End Sub

    Private Sub Menu_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        cnx.Close()
        If Principal.TPrivAñAp = "False" Then
            ApuntesFacturasToolStripMenuItem.Enabled = False
        End If

        If Principal.TPrivConAp = "False" Then
            ConsultasToolStripMenuItem.Enabled = False
        End If

        If Principal.TPrivBalances = "False" Then
            BalancesToolStripMenuItem.Enabled = False
        End If

        If Principal.TPrivPresupuestos = "False" Then
            PresupuestosToolStripMenuItem.Enabled = False
        End If

        If Principal.TPrivClientes = "False" Then
            ClientesToolStripMenuItem.Enabled = False
        End If

        If Principal.TPrivEdAp = "False" Then
            GraficosToolStripMenuItem.Enabled = False
        End If

        If Principal.TPrivUsuarios = "False" Then
            UsuariosToolStripMenuItem.Enabled = False
        End If


    End Sub

    Private Sub SalirToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles SalirToolStripMenuItem.Click
        Close()
    End Sub

    Private Sub ToolStripMenuItem1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ConsultasToolStripMenuItem.Click
        Consultas.MdiParent = Me
        Consultas.Show()
        Consultas.BringToFront()
    End Sub

    Private Sub UtilidadesToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles GraficosToolStripMenuItem.Click
        Process.Start("Manual.pdf")

    End Sub

    Private Sub BalancesToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles BalancesToolStripMenuItem.Click
        Balances.MdiParent = Me
        Balances.Show()
        Balances.BringToFront()
    End Sub

    Private Sub UsuariosToolStripMenuItem_Click(sender As System.Object, e As System.EventArgs) Handles ClientesToolStripMenuItem.Click
        Clientes.MdiParent = Me
        Clientes.Show()
        Clientes.BringToFront()
    End Sub
    
    Private Sub CuentasToolStripMenuItem1_Click(sender As System.Object, e As System.EventArgs) Handles CuentasToolStripMenuItem1.Click
        Cuentas.MdiParent = Me
        Cuentas.Show()
        Cuentas.BringToFront()
    End Sub

    Private Sub SubcuentasToolStripMenuItem1_Click(sender As System.Object, e As System.EventArgs) Handles SubcuentasToolStripMenuItem1.Click
        Subcuentas.MdiParent = Me
        Subcuentas.Show()
        Subcuentas.BringToFront()
    End Sub

    Private Sub DiariosToolStripMenuItem1_Click(sender As System.Object, e As System.EventArgs) Handles DiariosToolStripMenuItem1.Click
        Diarios.MdiParent = Me
        Diarios.Show()
        Diarios.BringToFront()
    End Sub

    Private Sub ConceptosToolStripMenuItem1_Click(sender As System.Object, e As System.EventArgs) Handles ConceptosToolStripMenuItem1.Click
        Conceptos.MdiParent = Me
        Conceptos.Show()
        Conceptos.BringToFront()
    End Sub
        
    Private Sub UsuariosToolStripMenuItem_Click_1(sender As System.Object, e As System.EventArgs) Handles UsuariosToolStripMenuItem.Click
        Usuarios.MdiParent = Me
        Usuarios.Show()
        Usuarios.BringToFront()
    End Sub
End Class
