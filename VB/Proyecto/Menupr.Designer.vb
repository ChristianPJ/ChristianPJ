<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Menupr
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub


    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Menupr))
        Me.StatusStrip = New System.Windows.Forms.StatusStrip()
        Me.Estado = New System.Windows.Forms.ToolStripStatusLabel()
        Me.ToolTip = New System.Windows.Forms.ToolTip(Me.components)
        Me.ApuntesFacturasToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.ContabilidadToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.CuentasToolStripMenuItem1 = New System.Windows.Forms.ToolStripMenuItem()
        Me.SubcuentasToolStripMenuItem1 = New System.Windows.Forms.ToolStripMenuItem()
        Me.DiariosToolStripMenuItem1 = New System.Windows.Forms.ToolStripMenuItem()
        Me.ConceptosToolStripMenuItem1 = New System.Windows.Forms.ToolStripMenuItem()
        Me.DepartamentosToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.CentrosDeCosteToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.ProyectosToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.PresupuestosToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.BalancesToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.ClientesToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.GraficosToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.SalirToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.MenuStrip1 = New System.Windows.Forms.MenuStrip()
        Me.ConsultasToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.UsuariosToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.StatusStrip.SuspendLayout()
        Me.MenuStrip1.SuspendLayout()
        Me.SuspendLayout()
        '
        'StatusStrip
        '
        Me.StatusStrip.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.Estado})
        Me.StatusStrip.Location = New System.Drawing.Point(201, 610)
        Me.StatusStrip.Name = "StatusStrip"
        Me.StatusStrip.Size = New System.Drawing.Size(983, 22)
        Me.StatusStrip.TabIndex = 7
        Me.StatusStrip.Text = "StatusStrip"
        '
        'Estado
        '
        Me.Estado.Name = "Estado"
        Me.Estado.Size = New System.Drawing.Size(42, 17)
        Me.Estado.Text = "Estado"
        '
        'ApuntesFacturasToolStripMenuItem
        '
        Me.ApuntesFacturasToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ApuntesFacturasToolStripMenuItem.Image = CType(resources.GetObject("ApuntesFacturasToolStripMenuItem.Image"), System.Drawing.Image)
        Me.ApuntesFacturasToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.ApuntesFacturasToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.ApuntesFacturasToolStripMenuItem.Name = "ApuntesFacturasToolStripMenuItem"
        Me.ApuntesFacturasToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.ApuntesFacturasToolStripMenuItem.Text = "  Apuntes / Facturas"
        '
        'ContabilidadToolStripMenuItem
        '
        Me.ContabilidadToolStripMenuItem.BackColor = System.Drawing.SystemColors.Control
        Me.ContabilidadToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.CuentasToolStripMenuItem1, Me.SubcuentasToolStripMenuItem1, Me.DiariosToolStripMenuItem1, Me.ConceptosToolStripMenuItem1})
        Me.ContabilidadToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ContabilidadToolStripMenuItem.Image = CType(resources.GetObject("ContabilidadToolStripMenuItem.Image"), System.Drawing.Image)
        Me.ContabilidadToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.ContabilidadToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.ContabilidadToolStripMenuItem.Name = "ContabilidadToolStripMenuItem"
        Me.ContabilidadToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.ContabilidadToolStripMenuItem.Text = "  M. Contabilidad"
        '
        'CuentasToolStripMenuItem1
        '
        Me.CuentasToolStripMenuItem1.BackColor = System.Drawing.SystemColors.ControlLight
        Me.CuentasToolStripMenuItem1.Image = CType(resources.GetObject("CuentasToolStripMenuItem1.Image"), System.Drawing.Image)
        Me.CuentasToolStripMenuItem1.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.CuentasToolStripMenuItem1.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.CuentasToolStripMenuItem1.Name = "CuentasToolStripMenuItem1"
        Me.CuentasToolStripMenuItem1.Size = New System.Drawing.Size(185, 46)
        Me.CuentasToolStripMenuItem1.Text = "  Cuentas"
        '
        'SubcuentasToolStripMenuItem1
        '
        Me.SubcuentasToolStripMenuItem1.Image = CType(resources.GetObject("SubcuentasToolStripMenuItem1.Image"), System.Drawing.Image)
        Me.SubcuentasToolStripMenuItem1.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.SubcuentasToolStripMenuItem1.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.SubcuentasToolStripMenuItem1.Name = "SubcuentasToolStripMenuItem1"
        Me.SubcuentasToolStripMenuItem1.Size = New System.Drawing.Size(185, 46)
        Me.SubcuentasToolStripMenuItem1.Text = "  Subcuentas"
        '
        'DiariosToolStripMenuItem1
        '
        Me.DiariosToolStripMenuItem1.BackColor = System.Drawing.SystemColors.ControlLight
        Me.DiariosToolStripMenuItem1.Image = CType(resources.GetObject("DiariosToolStripMenuItem1.Image"), System.Drawing.Image)
        Me.DiariosToolStripMenuItem1.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.DiariosToolStripMenuItem1.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.DiariosToolStripMenuItem1.Name = "DiariosToolStripMenuItem1"
        Me.DiariosToolStripMenuItem1.Size = New System.Drawing.Size(185, 46)
        Me.DiariosToolStripMenuItem1.Text = "  Diarios"
        '
        'ConceptosToolStripMenuItem1
        '
        Me.ConceptosToolStripMenuItem1.Image = CType(resources.GetObject("ConceptosToolStripMenuItem1.Image"), System.Drawing.Image)
        Me.ConceptosToolStripMenuItem1.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.ConceptosToolStripMenuItem1.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.ConceptosToolStripMenuItem1.Name = "ConceptosToolStripMenuItem1"
        Me.ConceptosToolStripMenuItem1.Size = New System.Drawing.Size(185, 46)
        Me.ConceptosToolStripMenuItem1.Text = "  Conceptos"
        '
        'DepartamentosToolStripMenuItem
        '
        Me.DepartamentosToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlLight
        Me.DepartamentosToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.DepartamentosToolStripMenuItem.Image = CType(resources.GetObject("DepartamentosToolStripMenuItem.Image"), System.Drawing.Image)
        Me.DepartamentosToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.DepartamentosToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.DepartamentosToolStripMenuItem.Name = "DepartamentosToolStripMenuItem"
        Me.DepartamentosToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.DepartamentosToolStripMenuItem.Text = "  Departamentos"
        '
        'CentrosDeCosteToolStripMenuItem
        '
        Me.CentrosDeCosteToolStripMenuItem.BackColor = System.Drawing.SystemColors.Control
        Me.CentrosDeCosteToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.CentrosDeCosteToolStripMenuItem.Image = CType(resources.GetObject("CentrosDeCosteToolStripMenuItem.Image"), System.Drawing.Image)
        Me.CentrosDeCosteToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.CentrosDeCosteToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.CentrosDeCosteToolStripMenuItem.Name = "CentrosDeCosteToolStripMenuItem"
        Me.CentrosDeCosteToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.CentrosDeCosteToolStripMenuItem.Text = "  Centros de Coste"
        '
        'ProyectosToolStripMenuItem
        '
        Me.ProyectosToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlLight
        Me.ProyectosToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ProyectosToolStripMenuItem.Image = CType(resources.GetObject("ProyectosToolStripMenuItem.Image"), System.Drawing.Image)
        Me.ProyectosToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.ProyectosToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.ProyectosToolStripMenuItem.Name = "ProyectosToolStripMenuItem"
        Me.ProyectosToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.ProyectosToolStripMenuItem.Text = "  Proyectos"
        '
        'PresupuestosToolStripMenuItem
        '
        Me.PresupuestosToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlLight
        Me.PresupuestosToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.PresupuestosToolStripMenuItem.Image = CType(resources.GetObject("PresupuestosToolStripMenuItem.Image"), System.Drawing.Image)
        Me.PresupuestosToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.PresupuestosToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.PresupuestosToolStripMenuItem.Name = "PresupuestosToolStripMenuItem"
        Me.PresupuestosToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.PresupuestosToolStripMenuItem.Text = "  Presupuestos"
        '
        'BalancesToolStripMenuItem
        '
        Me.BalancesToolStripMenuItem.BackColor = System.Drawing.SystemColors.Control
        Me.BalancesToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.BalancesToolStripMenuItem.Image = CType(resources.GetObject("BalancesToolStripMenuItem.Image"), System.Drawing.Image)
        Me.BalancesToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.BalancesToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.BalancesToolStripMenuItem.Name = "BalancesToolStripMenuItem"
        Me.BalancesToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.BalancesToolStripMenuItem.Text = "  Balances"
        '
        'ClientesToolStripMenuItem
        '
        Me.ClientesToolStripMenuItem.BackColor = System.Drawing.SystemColors.Control
        Me.ClientesToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ClientesToolStripMenuItem.Image = CType(resources.GetObject("ClientesToolStripMenuItem.Image"), System.Drawing.Image)
        Me.ClientesToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.ClientesToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.ClientesToolStripMenuItem.Name = "ClientesToolStripMenuItem"
        Me.ClientesToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.ClientesToolStripMenuItem.Text = "  Clientes"
        '
        'GraficosToolStripMenuItem
        '
        Me.GraficosToolStripMenuItem.BackColor = System.Drawing.SystemColors.Control
        Me.GraficosToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.GraficosToolStripMenuItem.Image = CType(resources.GetObject("GraficosToolStripMenuItem.Image"), System.Drawing.Image)
        Me.GraficosToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.GraficosToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.GraficosToolStripMenuItem.Name = "GraficosToolStripMenuItem"
        Me.GraficosToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.GraficosToolStripMenuItem.Text = "  Ayuda"
        '
        'SalirToolStripMenuItem
        '
        Me.SalirToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlLight
        Me.SalirToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.SalirToolStripMenuItem.Image = CType(resources.GetObject("SalirToolStripMenuItem.Image"), System.Drawing.Image)
        Me.SalirToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.SalirToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.SalirToolStripMenuItem.Name = "SalirToolStripMenuItem"
        Me.SalirToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.SalirToolStripMenuItem.Text = "  Salir"
        '
        'MenuStrip1
        '
        Me.MenuStrip1.Dock = System.Windows.Forms.DockStyle.Left
        Me.MenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.ApuntesFacturasToolStripMenuItem, Me.ConsultasToolStripMenuItem, Me.ContabilidadToolStripMenuItem, Me.DepartamentosToolStripMenuItem, Me.CentrosDeCosteToolStripMenuItem, Me.ProyectosToolStripMenuItem, Me.BalancesToolStripMenuItem, Me.PresupuestosToolStripMenuItem, Me.ClientesToolStripMenuItem, Me.UsuariosToolStripMenuItem, Me.GraficosToolStripMenuItem, Me.SalirToolStripMenuItem})
        Me.MenuStrip1.Location = New System.Drawing.Point(0, 0)
        Me.MenuStrip1.Name = "MenuStrip1"
        Me.MenuStrip1.Size = New System.Drawing.Size(201, 632)
        Me.MenuStrip1.TabIndex = 9
        Me.MenuStrip1.Text = "MenuStrip1"
        '
        'ConsultasToolStripMenuItem
        '
        Me.ConsultasToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlLight
        Me.ConsultasToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ConsultasToolStripMenuItem.Image = CType(resources.GetObject("ConsultasToolStripMenuItem.Image"), System.Drawing.Image)
        Me.ConsultasToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.ConsultasToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.ConsultasToolStripMenuItem.Name = "ConsultasToolStripMenuItem"
        Me.ConsultasToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.ConsultasToolStripMenuItem.Text = "  Consultas"
        '
        'UsuariosToolStripMenuItem
        '
        Me.UsuariosToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlLight
        Me.UsuariosToolStripMenuItem.Font = New System.Drawing.Font("Tahoma", 11.25!)
        Me.UsuariosToolStripMenuItem.Image = CType(resources.GetObject("UsuariosToolStripMenuItem.Image"), System.Drawing.Image)
        Me.UsuariosToolStripMenuItem.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.UsuariosToolStripMenuItem.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None
        Me.UsuariosToolStripMenuItem.Name = "UsuariosToolStripMenuItem"
        Me.UsuariosToolStripMenuItem.Size = New System.Drawing.Size(188, 44)
        Me.UsuariosToolStripMenuItem.Text = "  Usuarios"
        '
        'Menupr
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImage = CType(resources.GetObject("$this.BackgroundImage"), System.Drawing.Image)
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.ClientSize = New System.Drawing.Size(1184, 632)
        Me.Controls.Add(Me.StatusStrip)
        Me.Controls.Add(Me.MenuStrip1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.IsMdiContainer = True
        Me.MaximizeBox = False
        Me.Name = "Menupr"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Menu"
        Me.StatusStrip.ResumeLayout(False)
        Me.StatusStrip.PerformLayout()
        Me.MenuStrip1.ResumeLayout(False)
        Me.MenuStrip1.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents ToolTip As System.Windows.Forms.ToolTip
    Friend WithEvents Estado As System.Windows.Forms.ToolStripStatusLabel
    Friend WithEvents StatusStrip As System.Windows.Forms.StatusStrip
    Friend WithEvents ApuntesFacturasToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents ContabilidadToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents DepartamentosToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents CentrosDeCosteToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents ProyectosToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents PresupuestosToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents BalancesToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents ClientesToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents GraficosToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents SalirToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents MenuStrip1 As System.Windows.Forms.MenuStrip
    Friend WithEvents ConsultasToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents CuentasToolStripMenuItem1 As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents SubcuentasToolStripMenuItem1 As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents DiariosToolStripMenuItem1 As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents ConceptosToolStripMenuItem1 As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents UsuariosToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem

End Class
