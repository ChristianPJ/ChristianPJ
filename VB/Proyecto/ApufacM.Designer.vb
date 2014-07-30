<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class ApufacM
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(ApufacM))
        Me.Cantidad = New System.Windows.Forms.NumericUpDown()
        Me.Asiento = New System.Windows.Forms.Label()
        Me.Combodiario = New System.Windows.Forms.ComboBox()
        Me.Fecha = New System.Windows.Forms.DateTimePicker()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.Comboconcepto = New System.Windows.Forms.ComboBox()
        Me.Proyecto = New System.Windows.Forms.TextBox()
        Me.Centrocoste = New System.Windows.Forms.TextBox()
        Me.Departamento = New System.Windows.Forms.TextBox()
        Me.Label11 = New System.Windows.Forms.Label()
        Me.Label12 = New System.Windows.Forms.Label()
        Me.Label13 = New System.Windows.Forms.Label()
        Me.Subcuenta = New System.Windows.Forms.TextBox()
        Me.Label10 = New System.Windows.Forms.Label()
        Me.Label9 = New System.Windows.Forms.Label()
        Me.Debehaber = New System.Windows.Forms.TextBox()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.Numdocumento = New System.Windows.Forms.TextBox()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Modificar = New System.Windows.Forms.Button()
        Me.Iva = New System.Windows.Forms.TextBox()
        Me.Label15 = New System.Windows.Forms.Label()
        Me.TextBox4 = New System.Windows.Forms.TextBox()
        Me.ClienteID = New System.Windows.Forms.Label()
        CType(Me.Cantidad, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Cantidad
        '
        Me.Cantidad.DecimalPlaces = 2
        Me.Cantidad.InterceptArrowKeys = False
        Me.Cantidad.Location = New System.Drawing.Point(633, 143)
        Me.Cantidad.Maximum = New Decimal(New Integer() {10000, 0, 0, 0})
        Me.Cantidad.Name = "Cantidad"
        Me.Cantidad.Size = New System.Drawing.Size(137, 20)
        Me.Cantidad.TabIndex = 127
        Me.Cantidad.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Asiento
        '
        Me.Asiento.AutoSize = True
        Me.Asiento.Location = New System.Drawing.Point(115, 91)
        Me.Asiento.Name = "Asiento"
        Me.Asiento.Size = New System.Drawing.Size(10, 13)
        Me.Asiento.TabIndex = 126
        Me.Asiento.Text = "-"
        '
        'Combodiario
        '
        Me.Combodiario.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.Combodiario.FormattingEnabled = True
        Me.Combodiario.Location = New System.Drawing.Point(364, 60)
        Me.Combodiario.Name = "Combodiario"
        Me.Combodiario.Size = New System.Drawing.Size(136, 21)
        Me.Combodiario.Sorted = True
        Me.Combodiario.TabIndex = 125
        '
        'Fecha
        '
        Me.Fecha.Format = System.Windows.Forms.DateTimePickerFormat.Custom
        Me.Fecha.Location = New System.Drawing.Point(118, 32)
        Me.Fecha.Name = "Fecha"
        Me.Fecha.Size = New System.Drawing.Size(137, 20)
        Me.Fecha.TabIndex = 124
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(538, 146)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(55, 13)
        Me.Label6.TabIndex = 123
        Me.Label6.Text = "Cantidad :"
        '
        'Comboconcepto
        '
        Me.Comboconcepto.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.Comboconcepto.FormattingEnabled = True
        Me.Comboconcepto.Location = New System.Drawing.Point(364, 87)
        Me.Comboconcepto.Name = "Comboconcepto"
        Me.Comboconcepto.Size = New System.Drawing.Size(137, 21)
        Me.Comboconcepto.Sorted = True
        Me.Comboconcepto.TabIndex = 122
        '
        'Proyecto
        '
        Me.Proyecto.Location = New System.Drawing.Point(633, 84)
        Me.Proyecto.Name = "Proyecto"
        Me.Proyecto.Size = New System.Drawing.Size(137, 20)
        Me.Proyecto.TabIndex = 120
        Me.Proyecto.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Centrocoste
        '
        Me.Centrocoste.Location = New System.Drawing.Point(633, 58)
        Me.Centrocoste.Name = "Centrocoste"
        Me.Centrocoste.Size = New System.Drawing.Size(137, 20)
        Me.Centrocoste.TabIndex = 119
        Me.Centrocoste.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Departamento
        '
        Me.Departamento.Location = New System.Drawing.Point(633, 32)
        Me.Departamento.Name = "Departamento"
        Me.Departamento.Size = New System.Drawing.Size(137, 20)
        Me.Departamento.TabIndex = 118
        Me.Departamento.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label11
        '
        Me.Label11.AutoSize = True
        Me.Label11.Location = New System.Drawing.Point(538, 91)
        Me.Label11.Name = "Label11"
        Me.Label11.Size = New System.Drawing.Size(55, 13)
        Me.Label11.TabIndex = 117
        Me.Label11.Text = "Proyecto :"
        '
        'Label12
        '
        Me.Label12.AutoSize = True
        Me.Label12.Location = New System.Drawing.Point(538, 63)
        Me.Label12.Name = "Label12"
        Me.Label12.Size = New System.Drawing.Size(89, 13)
        Me.Label12.TabIndex = 116
        Me.Label12.Text = "Centro de Coste :"
        '
        'Label13
        '
        Me.Label13.AutoSize = True
        Me.Label13.Location = New System.Drawing.Point(538, 35)
        Me.Label13.Name = "Label13"
        Me.Label13.Size = New System.Drawing.Size(80, 13)
        Me.Label13.TabIndex = 115
        Me.Label13.Text = "Departamento :"
        '
        'Subcuenta
        '
        Me.Subcuenta.Location = New System.Drawing.Point(364, 32)
        Me.Subcuenta.Name = "Subcuenta"
        Me.Subcuenta.Size = New System.Drawing.Size(137, 20)
        Me.Subcuenta.TabIndex = 114
        '
        'Label10
        '
        Me.Label10.AutoSize = True
        Me.Label10.Location = New System.Drawing.Point(282, 91)
        Me.Label10.Name = "Label10"
        Me.Label10.Size = New System.Drawing.Size(59, 13)
        Me.Label10.TabIndex = 113
        Me.Label10.Text = "Concepto :"
        '
        'Label9
        '
        Me.Label9.AutoSize = True
        Me.Label9.Location = New System.Drawing.Point(282, 63)
        Me.Label9.Name = "Label9"
        Me.Label9.Size = New System.Drawing.Size(40, 13)
        Me.Label9.TabIndex = 112
        Me.Label9.Text = "Diario :"
        '
        'Debehaber
        '
        Me.Debehaber.Location = New System.Drawing.Point(118, 116)
        Me.Debehaber.Name = "Debehaber"
        Me.Debehaber.Size = New System.Drawing.Size(26, 20)
        Me.Debehaber.TabIndex = 111
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Location = New System.Drawing.Point(29, 119)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(79, 13)
        Me.Label8.TabIndex = 110
        Me.Label8.Text = "Debe / Haber :"
        '
        'Numdocumento
        '
        Me.Numdocumento.Location = New System.Drawing.Point(118, 60)
        Me.Numdocumento.Name = "Numdocumento"
        Me.Numdocumento.Size = New System.Drawing.Size(137, 20)
        Me.Numdocumento.TabIndex = 109
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(282, 35)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(76, 13)
        Me.Label5.TabIndex = 108
        Me.Label5.Text = "SubcuentaID :"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(29, 91)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(48, 13)
        Me.Label4.TabIndex = 107
        Me.Label4.Text = "Asiento :"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(29, 63)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(83, 13)
        Me.Label3.TabIndex = 106
        Me.Label3.Text = "Nº Documento :"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(29, 35)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(43, 13)
        Me.Label2.TabIndex = 105
        Me.Label2.Text = "Fecha :"
        '
        'Modificar
        '
        Me.Modificar.Location = New System.Drawing.Point(645, 192)
        Me.Modificar.Name = "Modificar"
        Me.Modificar.Size = New System.Drawing.Size(116, 26)
        Me.Modificar.TabIndex = 135
        Me.Modificar.Text = "Modificar"
        Me.Modificar.UseVisualStyleBackColor = True
        '
        'Iva
        '
        Me.Iva.Location = New System.Drawing.Point(363, 143)
        Me.Iva.Name = "Iva"
        Me.Iva.Size = New System.Drawing.Size(137, 20)
        Me.Iva.TabIndex = 139
        Me.Iva.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label15
        '
        Me.Label15.AutoSize = True
        Me.Label15.Location = New System.Drawing.Point(282, 146)
        Me.Label15.Name = "Label15"
        Me.Label15.Size = New System.Drawing.Size(51, 13)
        Me.Label15.TabIndex = 138
        Me.Label15.Text = "TipoIVA :"
        '
        'TextBox4
        '
        Me.TextBox4.Location = New System.Drawing.Point(111, 143)
        Me.TextBox4.Name = "TextBox4"
        Me.TextBox4.Size = New System.Drawing.Size(137, 20)
        Me.TextBox4.TabIndex = 137
        Me.TextBox4.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'ClienteID
        '
        Me.ClienteID.AutoSize = True
        Me.ClienteID.Location = New System.Drawing.Point(29, 146)
        Me.ClienteID.Name = "ClienteID"
        Me.ClienteID.Size = New System.Drawing.Size(56, 13)
        Me.ClienteID.TabIndex = 136
        Me.ClienteID.Text = "ClienteID :"
        '
        'ApufacM
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(792, 241)
        Me.Controls.Add(Me.Iva)
        Me.Controls.Add(Me.Label15)
        Me.Controls.Add(Me.TextBox4)
        Me.Controls.Add(Me.ClienteID)
        Me.Controls.Add(Me.Modificar)
        Me.Controls.Add(Me.Cantidad)
        Me.Controls.Add(Me.Asiento)
        Me.Controls.Add(Me.Combodiario)
        Me.Controls.Add(Me.Fecha)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Comboconcepto)
        Me.Controls.Add(Me.Proyecto)
        Me.Controls.Add(Me.Centrocoste)
        Me.Controls.Add(Me.Departamento)
        Me.Controls.Add(Me.Label11)
        Me.Controls.Add(Me.Label12)
        Me.Controls.Add(Me.Label13)
        Me.Controls.Add(Me.Subcuenta)
        Me.Controls.Add(Me.Label10)
        Me.Controls.Add(Me.Label9)
        Me.Controls.Add(Me.Debehaber)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.Numdocumento)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.MaximizeBox = False
        Me.MinimizeBox = False
        Me.Name = "ApufacM"
        Me.ShowIcon = False
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Modificar Apuntes / Facturas"
        CType(Me.Cantidad, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Cantidad As System.Windows.Forms.NumericUpDown
    Friend WithEvents Asiento As System.Windows.Forms.Label
    Friend WithEvents Combodiario As System.Windows.Forms.ComboBox
    Friend WithEvents Fecha As System.Windows.Forms.DateTimePicker
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Comboconcepto As System.Windows.Forms.ComboBox
    Friend WithEvents Proyecto As System.Windows.Forms.TextBox
    Friend WithEvents Centrocoste As System.Windows.Forms.TextBox
    Friend WithEvents Departamento As System.Windows.Forms.TextBox
    Friend WithEvents Label11 As System.Windows.Forms.Label
    Friend WithEvents Label12 As System.Windows.Forms.Label
    Friend WithEvents Label13 As System.Windows.Forms.Label
    Friend WithEvents Subcuenta As System.Windows.Forms.TextBox
    Friend WithEvents Label10 As System.Windows.Forms.Label
    Friend WithEvents Label9 As System.Windows.Forms.Label
    Friend WithEvents Debehaber As System.Windows.Forms.TextBox
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents Numdocumento As System.Windows.Forms.TextBox
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Modificar As System.Windows.Forms.Button
    Friend WithEvents Iva As System.Windows.Forms.TextBox
    Friend WithEvents Label15 As System.Windows.Forms.Label
    Friend WithEvents TextBox4 As System.Windows.Forms.TextBox
    Friend WithEvents ClienteID As System.Windows.Forms.Label
End Class
