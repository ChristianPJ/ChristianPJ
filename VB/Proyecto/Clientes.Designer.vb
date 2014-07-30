<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Clientes
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Clientes))
        Me.Poblacion = New System.Windows.Forms.TextBox()
        Me.Pais = New System.Windows.Forms.TextBox()
        Me.Postal = New System.Windows.Forms.TextBox()
        Me.Nif = New System.Windows.Forms.TextBox()
        Me.Label12 = New System.Windows.Forms.Label()
        Me.Label13 = New System.Windows.Forms.Label()
        Me.Codigo = New System.Windows.Forms.TextBox()
        Me.Label10 = New System.Windows.Forms.Label()
        Me.Direccion = New System.Windows.Forms.TextBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.Descripcion = New System.Windows.Forms.TextBox()
        Me.Telefono1 = New System.Windows.Forms.TextBox()
        Me.Telefono2 = New System.Windows.Forms.TextBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.Correo = New System.Windows.Forms.TextBox()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.Web = New System.Windows.Forms.TextBox()
        Me.Label9 = New System.Windows.Forms.Label()
        Me.Añadir = New System.Windows.Forms.Button()
        Me.Rellenar = New System.Windows.Forms.Button()
        Me.Modificar = New System.Windows.Forms.Button()
        Me.Borrar = New System.Windows.Forms.Button()
        Me.Label11 = New System.Windows.Forms.Label()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.Imprimir = New System.Windows.Forms.Button()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Poblacion
        '
        Me.Poblacion.Location = New System.Drawing.Point(167, 139)
        Me.Poblacion.Name = "Poblacion"
        Me.Poblacion.Size = New System.Drawing.Size(137, 20)
        Me.Poblacion.TabIndex = 70
        '
        'Pais
        '
        Me.Pais.Location = New System.Drawing.Point(410, 139)
        Me.Pais.Name = "Pais"
        Me.Pais.Size = New System.Drawing.Size(137, 20)
        Me.Pais.TabIndex = 65
        Me.Pais.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Postal
        '
        Me.Postal.Location = New System.Drawing.Point(590, 99)
        Me.Postal.Name = "Postal"
        Me.Postal.Size = New System.Drawing.Size(77, 20)
        Me.Postal.TabIndex = 64
        Me.Postal.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Nif
        '
        Me.Nif.Location = New System.Drawing.Point(382, 59)
        Me.Nif.Name = "Nif"
        Me.Nif.Size = New System.Drawing.Size(137, 20)
        Me.Nif.TabIndex = 63
        Me.Nif.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label12
        '
        Me.Label12.AutoSize = True
        Me.Label12.Location = New System.Drawing.Point(506, 102)
        Me.Label12.Name = "Label12"
        Me.Label12.Size = New System.Drawing.Size(78, 13)
        Me.Label12.TabIndex = 61
        Me.Label12.Text = "Código Postal :"
        '
        'Label13
        '
        Me.Label13.AutoSize = True
        Me.Label13.Location = New System.Drawing.Point(320, 62)
        Me.Label13.Name = "Label13"
        Me.Label13.Size = New System.Drawing.Size(49, 13)
        Me.Label13.TabIndex = 60
        Me.Label13.Text = "Nif / Cif :"
        '
        'Codigo
        '
        Me.Codigo.Location = New System.Drawing.Point(167, 59)
        Me.Codigo.Name = "Codigo"
        Me.Codigo.Size = New System.Drawing.Size(137, 20)
        Me.Codigo.TabIndex = 59
        Me.Codigo.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label10
        '
        Me.Label10.AutoSize = True
        Me.Label10.Location = New System.Drawing.Point(369, 142)
        Me.Label10.Name = "Label10"
        Me.Label10.Size = New System.Drawing.Size(35, 13)
        Me.Label10.TabIndex = 58
        Me.Label10.Text = "País :"
        '
        'Direccion
        '
        Me.Direccion.Location = New System.Drawing.Point(167, 99)
        Me.Direccion.Name = "Direccion"
        Me.Direccion.Size = New System.Drawing.Size(291, 20)
        Me.Direccion.TabIndex = 54
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(82, 142)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(60, 13)
        Me.Label4.TabIndex = 52
        Me.Label4.Text = "Población :"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(82, 102)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(58, 13)
        Me.Label3.TabIndex = 51
        Me.Label3.Text = "Dirección :"
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = CType(resources.GetObject("PictureBox1.Image"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(12, 12)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(53, 48)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PictureBox1.TabIndex = 49
        Me.PictureBox1.TabStop = False
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(71, 25)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(69, 18)
        Me.Label1.TabIndex = 48
        Me.Label1.Text = "Clientes"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(82, 62)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(46, 13)
        Me.Label2.TabIndex = 74
        Me.Label2.Text = "Código :"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(545, 62)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(69, 13)
        Me.Label5.TabIndex = 76
        Me.Label5.Text = "Descripción :"
        '
        'Descripcion
        '
        Me.Descripcion.Location = New System.Drawing.Point(632, 59)
        Me.Descripcion.Name = "Descripcion"
        Me.Descripcion.Size = New System.Drawing.Size(187, 20)
        Me.Descripcion.TabIndex = 75
        '
        'Telefono1
        '
        Me.Telefono1.Location = New System.Drawing.Point(167, 179)
        Me.Telefono1.Name = "Telefono1"
        Me.Telefono1.Size = New System.Drawing.Size(137, 20)
        Me.Telefono1.TabIndex = 80
        '
        'Telefono2
        '
        Me.Telefono2.Location = New System.Drawing.Point(439, 179)
        Me.Telefono2.Name = "Telefono2"
        Me.Telefono2.Size = New System.Drawing.Size(137, 20)
        Me.Telefono2.TabIndex = 79
        Me.Telefono2.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(369, 182)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(64, 13)
        Me.Label6.TabIndex = 78
        Me.Label6.Text = "Teléfono 2 :"
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Location = New System.Drawing.Point(82, 182)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(55, 13)
        Me.Label7.TabIndex = 77
        Me.Label7.Text = "Teléfono :"
        '
        'Correo
        '
        Me.Correo.Location = New System.Drawing.Point(167, 219)
        Me.Correo.Name = "Correo"
        Me.Correo.Size = New System.Drawing.Size(172, 20)
        Me.Correo.TabIndex = 82
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Location = New System.Drawing.Point(82, 222)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(38, 13)
        Me.Label8.TabIndex = 81
        Me.Label8.Text = "Email :"
        '
        'Web
        '
        Me.Web.Location = New System.Drawing.Point(447, 219)
        Me.Web.Name = "Web"
        Me.Web.Size = New System.Drawing.Size(212, 20)
        Me.Web.TabIndex = 84
        '
        'Label9
        '
        Me.Label9.AutoSize = True
        Me.Label9.Location = New System.Drawing.Point(369, 222)
        Me.Label9.Name = "Label9"
        Me.Label9.Size = New System.Drawing.Size(72, 13)
        Me.Label9.TabIndex = 83
        Me.Label9.Text = "Página Web :"
        '
        'Añadir
        '
        Me.Añadir.Location = New System.Drawing.Point(207, 263)
        Me.Añadir.Name = "Añadir"
        Me.Añadir.Size = New System.Drawing.Size(95, 27)
        Me.Añadir.TabIndex = 85
        Me.Añadir.Text = "Añadir"
        Me.Añadir.UseVisualStyleBackColor = True
        '
        'Rellenar
        '
        Me.Rellenar.Location = New System.Drawing.Point(307, 263)
        Me.Rellenar.Name = "Rellenar"
        Me.Rellenar.Size = New System.Drawing.Size(95, 27)
        Me.Rellenar.TabIndex = 86
        Me.Rellenar.Text = "Rellenar"
        Me.Rellenar.UseVisualStyleBackColor = True
        '
        'Modificar
        '
        Me.Modificar.Location = New System.Drawing.Point(408, 263)
        Me.Modificar.Name = "Modificar"
        Me.Modificar.Size = New System.Drawing.Size(95, 27)
        Me.Modificar.TabIndex = 87
        Me.Modificar.Text = "Modificar"
        Me.Modificar.UseVisualStyleBackColor = True
        '
        'Borrar
        '
        Me.Borrar.Location = New System.Drawing.Point(509, 263)
        Me.Borrar.Name = "Borrar"
        Me.Borrar.Size = New System.Drawing.Size(95, 27)
        Me.Borrar.TabIndex = 88
        Me.Borrar.Text = "Borrar"
        Me.Borrar.UseVisualStyleBackColor = True
        '
        'Label11
        '
        Me.Label11.AutoSize = True
        Me.Label11.Location = New System.Drawing.Point(752, 490)
        Me.Label11.Name = "Label11"
        Me.Label11.Size = New System.Drawing.Size(49, 13)
        Me.Label11.TabIndex = 89
        Me.Label11.Text = "Usuario :"
        '
        'DataGridView1
        '
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.DataGridView1.Location = New System.Drawing.Point(85, 306)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.Size = New System.Drawing.Size(734, 165)
        Me.DataGridView1.TabIndex = 90
        '
        'Imprimir
        '
        Me.Imprimir.Image = CType(resources.GetObject("Imprimir.Image"), System.Drawing.Image)
        Me.Imprimir.Location = New System.Drawing.Point(724, 242)
        Me.Imprimir.Name = "Imprimir"
        Me.Imprimir.Size = New System.Drawing.Size(57, 48)
        Me.Imprimir.TabIndex = 119
        Me.Imprimir.UseVisualStyleBackColor = True
        '
        'Clientes
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(934, 512)
        Me.Controls.Add(Me.Imprimir)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.Label11)
        Me.Controls.Add(Me.Borrar)
        Me.Controls.Add(Me.Modificar)
        Me.Controls.Add(Me.Rellenar)
        Me.Controls.Add(Me.Añadir)
        Me.Controls.Add(Me.Web)
        Me.Controls.Add(Me.Label9)
        Me.Controls.Add(Me.Correo)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.Telefono1)
        Me.Controls.Add(Me.Telefono2)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Descripcion)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Poblacion)
        Me.Controls.Add(Me.Pais)
        Me.Controls.Add(Me.Postal)
        Me.Controls.Add(Me.Nif)
        Me.Controls.Add(Me.Label12)
        Me.Controls.Add(Me.Label13)
        Me.Controls.Add(Me.Codigo)
        Me.Controls.Add(Me.Label10)
        Me.Controls.Add(Me.Direccion)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.Label1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog
        Me.MaximizeBox = False
        Me.Name = "Clientes"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Clientes"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Poblacion As System.Windows.Forms.TextBox
    Friend WithEvents Pais As System.Windows.Forms.TextBox
    Friend WithEvents Postal As System.Windows.Forms.TextBox
    Friend WithEvents Nif As System.Windows.Forms.TextBox
    Friend WithEvents Label12 As System.Windows.Forms.Label
    Friend WithEvents Label13 As System.Windows.Forms.Label
    Friend WithEvents Codigo As System.Windows.Forms.TextBox
    Friend WithEvents Label10 As System.Windows.Forms.Label
    Friend WithEvents Direccion As System.Windows.Forms.TextBox
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents PictureBox1 As System.Windows.Forms.PictureBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Descripcion As System.Windows.Forms.TextBox
    Friend WithEvents Telefono1 As System.Windows.Forms.TextBox
    Friend WithEvents Telefono2 As System.Windows.Forms.TextBox
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents Correo As System.Windows.Forms.TextBox
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents Web As System.Windows.Forms.TextBox
    Friend WithEvents Label9 As System.Windows.Forms.Label
    Friend WithEvents Añadir As System.Windows.Forms.Button
    Friend WithEvents Rellenar As System.Windows.Forms.Button
    Friend WithEvents Modificar As System.Windows.Forms.Button
    Friend WithEvents Borrar As System.Windows.Forms.Button
    Friend WithEvents Label11 As System.Windows.Forms.Label
    Friend WithEvents DataGridView1 As System.Windows.Forms.DataGridView
    Friend WithEvents Imprimir As System.Windows.Forms.Button
End Class
