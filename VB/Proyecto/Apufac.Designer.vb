<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Apufac
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Apufac))
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.Numdocumento = New System.Windows.Forms.TextBox()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.Debehaber = New System.Windows.Forms.TextBox()
        Me.Label9 = New System.Windows.Forms.Label()
        Me.Label10 = New System.Windows.Forms.Label()
        Me.Subcuenta = New System.Windows.Forms.TextBox()
        Me.Proyecto = New System.Windows.Forms.TextBox()
        Me.Centrocoste = New System.Windows.Forms.TextBox()
        Me.Departamento = New System.Windows.Forms.TextBox()
        Me.Label11 = New System.Windows.Forms.Label()
        Me.Label12 = New System.Windows.Forms.Label()
        Me.Label13 = New System.Windows.Forms.Label()
        Me.CheckBox1 = New System.Windows.Forms.CheckBox()
        Me.TextBox4 = New System.Windows.Forms.TextBox()
        Me.ClienteID = New System.Windows.Forms.Label()
        Me.Label15 = New System.Windows.Forms.Label()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.Label16 = New System.Windows.Forms.Label()
        Me.Comboconcepto = New System.Windows.Forms.ComboBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.Finalizar = New System.Windows.Forms.Button()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.Sumatotal = New System.Windows.Forms.TextBox()
        Me.Fecha = New System.Windows.Forms.DateTimePicker()
        Me.Combodiario = New System.Windows.Forms.ComboBox()
        Me.Asiento = New System.Windows.Forms.Label()
        Me.Imprimir = New System.Windows.Forms.Button()
        Me.PrintDialog1 = New System.Windows.Forms.PrintDialog()
        Me.PrintDocument1 = New System.Drawing.Printing.PrintDocument()
        Me.Iva = New System.Windows.Forms.TextBox()
        Me.Cantidad = New System.Windows.Forms.NumericUpDown()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.Cantidad, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = CType(resources.GetObject("PictureBox1.Image"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(12, 12)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(53, 48)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PictureBox1.TabIndex = 3
        Me.PictureBox1.TabStop = False
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(71, 25)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(149, 18)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Apuntes / Facturas"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(71, 65)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(43, 13)
        Me.Label2.TabIndex = 4
        Me.Label2.Text = "Fecha :"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(71, 93)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(83, 13)
        Me.Label3.TabIndex = 5
        Me.Label3.Text = "Nº Documento :"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(71, 121)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(48, 13)
        Me.Label4.TabIndex = 6
        Me.Label4.Text = "Asiento :"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(344, 65)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(76, 13)
        Me.Label5.TabIndex = 7
        Me.Label5.Text = "SubcuentaID :"
        '
        'Numdocumento
        '
        Me.Numdocumento.Location = New System.Drawing.Point(160, 90)
        Me.Numdocumento.Name = "Numdocumento"
        Me.Numdocumento.Size = New System.Drawing.Size(137, 20)
        Me.Numdocumento.TabIndex = 8
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Location = New System.Drawing.Point(71, 149)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(79, 13)
        Me.Label8.TabIndex = 11
        Me.Label8.Text = "Debe / Haber :"
        '
        'Debehaber
        '
        Me.Debehaber.Location = New System.Drawing.Point(160, 146)
        Me.Debehaber.Name = "Debehaber"
        Me.Debehaber.Size = New System.Drawing.Size(26, 20)
        Me.Debehaber.TabIndex = 12
        '
        'Label9
        '
        Me.Label9.AutoSize = True
        Me.Label9.Location = New System.Drawing.Point(344, 93)
        Me.Label9.Name = "Label9"
        Me.Label9.Size = New System.Drawing.Size(40, 13)
        Me.Label9.TabIndex = 13
        Me.Label9.Text = "Diario :"
        '
        'Label10
        '
        Me.Label10.AutoSize = True
        Me.Label10.Location = New System.Drawing.Point(344, 121)
        Me.Label10.Name = "Label10"
        Me.Label10.Size = New System.Drawing.Size(59, 13)
        Me.Label10.TabIndex = 14
        Me.Label10.Text = "Concepto :"
        '
        'Subcuenta
        '
        Me.Subcuenta.Location = New System.Drawing.Point(426, 62)
        Me.Subcuenta.Name = "Subcuenta"
        Me.Subcuenta.Size = New System.Drawing.Size(160, 20)
        Me.Subcuenta.TabIndex = 16
        '
        'Proyecto
        '
        Me.Proyecto.Location = New System.Drawing.Point(715, 114)
        Me.Proyecto.Name = "Proyecto"
        Me.Proyecto.Size = New System.Drawing.Size(145, 20)
        Me.Proyecto.TabIndex = 24
        Me.Proyecto.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Centrocoste
        '
        Me.Centrocoste.Location = New System.Drawing.Point(715, 88)
        Me.Centrocoste.Name = "Centrocoste"
        Me.Centrocoste.Size = New System.Drawing.Size(145, 20)
        Me.Centrocoste.TabIndex = 23
        Me.Centrocoste.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Departamento
        '
        Me.Departamento.Location = New System.Drawing.Point(715, 62)
        Me.Departamento.Name = "Departamento"
        Me.Departamento.Size = New System.Drawing.Size(145, 20)
        Me.Departamento.TabIndex = 22
        Me.Departamento.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label11
        '
        Me.Label11.AutoSize = True
        Me.Label11.Location = New System.Drawing.Point(620, 121)
        Me.Label11.Name = "Label11"
        Me.Label11.Size = New System.Drawing.Size(55, 13)
        Me.Label11.TabIndex = 21
        Me.Label11.Text = "Proyecto :"
        '
        'Label12
        '
        Me.Label12.AutoSize = True
        Me.Label12.Location = New System.Drawing.Point(620, 93)
        Me.Label12.Name = "Label12"
        Me.Label12.Size = New System.Drawing.Size(89, 13)
        Me.Label12.TabIndex = 20
        Me.Label12.Text = "Centro de Coste :"
        '
        'Label13
        '
        Me.Label13.AutoSize = True
        Me.Label13.Location = New System.Drawing.Point(620, 65)
        Me.Label13.Name = "Label13"
        Me.Label13.Size = New System.Drawing.Size(80, 13)
        Me.Label13.TabIndex = 19
        Me.Label13.Text = "Departamento :"
        '
        'CheckBox1
        '
        Me.CheckBox1.AutoSize = True
        Me.CheckBox1.Location = New System.Drawing.Point(74, 176)
        Me.CheckBox1.Name = "CheckBox1"
        Me.CheckBox1.Size = New System.Drawing.Size(62, 17)
        Me.CheckBox1.TabIndex = 27
        Me.CheckBox1.Text = "Factura"
        Me.CheckBox1.UseVisualStyleBackColor = True
        '
        'TextBox4
        '
        Me.TextBox4.Enabled = False
        Me.TextBox4.Location = New System.Drawing.Point(153, 203)
        Me.TextBox4.Name = "TextBox4"
        Me.TextBox4.Size = New System.Drawing.Size(137, 20)
        Me.TextBox4.TabIndex = 29
        Me.TextBox4.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'ClienteID
        '
        Me.ClienteID.AutoSize = True
        Me.ClienteID.Location = New System.Drawing.Point(71, 206)
        Me.ClienteID.Name = "ClienteID"
        Me.ClienteID.Size = New System.Drawing.Size(56, 13)
        Me.ClienteID.TabIndex = 28
        Me.ClienteID.Text = "ClienteID :"
        '
        'Label15
        '
        Me.Label15.AutoSize = True
        Me.Label15.Location = New System.Drawing.Point(345, 206)
        Me.Label15.Name = "Label15"
        Me.Label15.Size = New System.Drawing.Size(51, 13)
        Me.Label15.TabIndex = 30
        Me.Label15.Text = "TipoIVA :"
        '
        'DataGridView1
        '
        Me.DataGridView1.AllowUserToAddRows = False
        Me.DataGridView1.AllowUserToDeleteRows = False
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.DataGridView1.Location = New System.Drawing.Point(37, 250)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.Size = New System.Drawing.Size(860, 177)
        Me.DataGridView1.TabIndex = 33
        '
        'Label16
        '
        Me.Label16.AutoSize = True
        Me.Label16.Location = New System.Drawing.Point(797, 490)
        Me.Label16.Name = "Label16"
        Me.Label16.Size = New System.Drawing.Size(49, 13)
        Me.Label16.TabIndex = 34
        Me.Label16.Text = "Usuario :"
        '
        'Comboconcepto
        '
        Me.Comboconcepto.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.Comboconcepto.FormattingEnabled = True
        Me.Comboconcepto.Location = New System.Drawing.Point(426, 117)
        Me.Comboconcepto.Name = "Comboconcepto"
        Me.Comboconcepto.Size = New System.Drawing.Size(160, 21)
        Me.Comboconcepto.Sorted = True
        Me.Comboconcepto.TabIndex = 35
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(620, 176)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(55, 13)
        Me.Label6.TabIndex = 38
        Me.Label6.Text = "Cantidad :"
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(698, 206)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(95, 27)
        Me.Button1.TabIndex = 40
        Me.Button1.Text = "Añadir"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'Finalizar
        '
        Me.Finalizar.Location = New System.Drawing.Point(802, 206)
        Me.Finalizar.Name = "Finalizar"
        Me.Finalizar.Size = New System.Drawing.Size(95, 27)
        Me.Finalizar.TabIndex = 42
        Me.Finalizar.Text = "Finalizar"
        Me.Finalizar.UseVisualStyleBackColor = True
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label7.Location = New System.Drawing.Point(703, 454)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(59, 20)
        Me.Label7.TabIndex = 43
        Me.Label7.Text = "Total :"
        '
        'Sumatotal
        '
        Me.Sumatotal.Location = New System.Drawing.Point(787, 454)
        Me.Sumatotal.Name = "Sumatotal"
        Me.Sumatotal.Size = New System.Drawing.Size(110, 20)
        Me.Sumatotal.TabIndex = 44
        Me.Sumatotal.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Fecha
        '
        Me.Fecha.Format = System.Windows.Forms.DateTimePickerFormat.Custom
        Me.Fecha.Location = New System.Drawing.Point(160, 62)
        Me.Fecha.Name = "Fecha"
        Me.Fecha.Size = New System.Drawing.Size(137, 20)
        Me.Fecha.TabIndex = 46
        '
        'Combodiario
        '
        Me.Combodiario.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.Combodiario.FormattingEnabled = True
        Me.Combodiario.Location = New System.Drawing.Point(426, 90)
        Me.Combodiario.Name = "Combodiario"
        Me.Combodiario.Size = New System.Drawing.Size(160, 21)
        Me.Combodiario.Sorted = True
        Me.Combodiario.TabIndex = 47
        '
        'Asiento
        '
        Me.Asiento.AutoSize = True
        Me.Asiento.Location = New System.Drawing.Point(157, 121)
        Me.Asiento.Name = "Asiento"
        Me.Asiento.Size = New System.Drawing.Size(10, 13)
        Me.Asiento.TabIndex = 48
        Me.Asiento.Text = "-"
        '
        'Imprimir
        '
        Me.Imprimir.Image = CType(resources.GetObject("Imprimir.Image"), System.Drawing.Image)
        Me.Imprimir.Location = New System.Drawing.Point(612, 439)
        Me.Imprimir.Name = "Imprimir"
        Me.Imprimir.Size = New System.Drawing.Size(57, 48)
        Me.Imprimir.TabIndex = 102
        Me.Imprimir.UseVisualStyleBackColor = True
        '
        'PrintDialog1
        '
        Me.PrintDialog1.UseEXDialog = True
        '
        'PrintDocument1
        '
        '
        'Iva
        '
        Me.Iva.Enabled = False
        Me.Iva.Location = New System.Drawing.Point(426, 203)
        Me.Iva.Name = "Iva"
        Me.Iva.Size = New System.Drawing.Size(160, 20)
        Me.Iva.TabIndex = 103
        Me.Iva.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Cantidad
        '
        Me.Cantidad.DecimalPlaces = 2
        Me.Cantidad.InterceptArrowKeys = False
        Me.Cantidad.Location = New System.Drawing.Point(715, 174)
        Me.Cantidad.Maximum = New Decimal(New Integer() {10000, 0, 0, 0})
        Me.Cantidad.Name = "Cantidad"
        Me.Cantidad.Size = New System.Drawing.Size(145, 20)
        Me.Cantidad.TabIndex = 104
        Me.Cantidad.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Apufac
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(934, 512)
        Me.Controls.Add(Me.Cantidad)
        Me.Controls.Add(Me.Iva)
        Me.Controls.Add(Me.Imprimir)
        Me.Controls.Add(Me.Asiento)
        Me.Controls.Add(Me.Combodiario)
        Me.Controls.Add(Me.Fecha)
        Me.Controls.Add(Me.Sumatotal)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.Finalizar)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Comboconcepto)
        Me.Controls.Add(Me.Label16)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.Label15)
        Me.Controls.Add(Me.TextBox4)
        Me.Controls.Add(Me.ClienteID)
        Me.Controls.Add(Me.CheckBox1)
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
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.Label1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog
        Me.MaximizeBox = False
        Me.Name = "Apufac"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Apufac"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.Cantidad, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents PictureBox1 As System.Windows.Forms.PictureBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Numdocumento As System.Windows.Forms.TextBox
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents Debehaber As System.Windows.Forms.TextBox
    Friend WithEvents Label9 As System.Windows.Forms.Label
    Friend WithEvents Label10 As System.Windows.Forms.Label
    Friend WithEvents Subcuenta As System.Windows.Forms.TextBox
    Friend WithEvents Proyecto As System.Windows.Forms.TextBox
    Friend WithEvents Centrocoste As System.Windows.Forms.TextBox
    Friend WithEvents Departamento As System.Windows.Forms.TextBox
    Friend WithEvents Label11 As System.Windows.Forms.Label
    Friend WithEvents Label12 As System.Windows.Forms.Label
    Friend WithEvents Label13 As System.Windows.Forms.Label
    Friend WithEvents CheckBox1 As System.Windows.Forms.CheckBox
    Friend WithEvents TextBox4 As System.Windows.Forms.TextBox
    Friend WithEvents ClienteID As System.Windows.Forms.Label
    Friend WithEvents Label15 As System.Windows.Forms.Label
    Friend WithEvents DataGridView1 As System.Windows.Forms.DataGridView
    Friend WithEvents Label16 As System.Windows.Forms.Label
    Friend WithEvents Comboconcepto As System.Windows.Forms.ComboBox
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Finalizar As System.Windows.Forms.Button
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents Sumatotal As System.Windows.Forms.TextBox
    Friend WithEvents Fecha As System.Windows.Forms.DateTimePicker
    Friend WithEvents Combodiario As System.Windows.Forms.ComboBox
    Friend WithEvents Asiento As System.Windows.Forms.Label
    Friend WithEvents Imprimir As System.Windows.Forms.Button
    Friend WithEvents PrintDialog1 As System.Windows.Forms.PrintDialog
    Friend WithEvents PrintDocument1 As System.Drawing.Printing.PrintDocument
    Friend WithEvents Iva As System.Windows.Forms.TextBox
    Friend WithEvents Cantidad As System.Windows.Forms.NumericUpDown
End Class
