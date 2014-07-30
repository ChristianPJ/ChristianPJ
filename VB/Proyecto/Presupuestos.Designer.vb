<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Presupuestos
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Presupuestos))
        Dim DataGridViewCellStyle3 As System.Windows.Forms.DataGridViewCellStyle = New System.Windows.Forms.DataGridViewCellStyle()
        Dim DataGridViewCellStyle4 As System.Windows.Forms.DataGridViewCellStyle = New System.Windows.Forms.DataGridViewCellStyle()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Mostrar = New System.Windows.Forms.Button()
        Me.Nivel4 = New System.Windows.Forms.RadioButton()
        Me.Nivel2 = New System.Windows.Forms.RadioButton()
        Me.Nivel3 = New System.Windows.Forms.RadioButton()
        Me.Nivel1 = New System.Windows.Forms.RadioButton()
        Me.Fecha2 = New System.Windows.Forms.DateTimePicker()
        Me.Fecha1 = New System.Windows.Forms.DateTimePicker()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.Imprimir = New System.Windows.Forms.Button()
        Me.PrintDocument1 = New System.Drawing.Printing.PrintDocument()
        Me.PrintDialog1 = New System.Windows.Forms.PrintDialog()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.TextBox1 = New System.Windows.Forms.TextBox()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.Añadir = New System.Windows.Forms.Button()
        Me.Fecha3 = New System.Windows.Forms.DateTimePicker()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.Debe = New System.Windows.Forms.NumericUpDown()
        Me.Haber = New System.Windows.Forms.NumericUpDown()
        Me.Label9 = New System.Windows.Forms.Label()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.Debe, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.Haber, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = CType(resources.GetObject("PictureBox1.Image"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(34, 23)
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
        Me.Label1.Location = New System.Drawing.Point(93, 38)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(112, 18)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Presupuestos"
        '
        'Mostrar
        '
        Me.Mostrar.Location = New System.Drawing.Point(767, 58)
        Me.Mostrar.Name = "Mostrar"
        Me.Mostrar.Size = New System.Drawing.Size(116, 26)
        Me.Mostrar.TabIndex = 120
        Me.Mostrar.Text = "Mostrar"
        Me.Mostrar.UseVisualStyleBackColor = True
        '
        'Nivel4
        '
        Me.Nivel4.AutoSize = True
        Me.Nivel4.Location = New System.Drawing.Point(620, 74)
        Me.Nivel4.Name = "Nivel4"
        Me.Nivel4.Size = New System.Drawing.Size(104, 17)
        Me.Nivel4.TabIndex = 119
        Me.Nivel4.TabStop = True
        Me.Nivel4.Text = "Nivel Subcuenta"
        Me.Nivel4.UseVisualStyleBackColor = True
        '
        'Nivel2
        '
        Me.Nivel2.AutoSize = True
        Me.Nivel2.Location = New System.Drawing.Point(620, 41)
        Me.Nivel2.Name = "Nivel2"
        Me.Nivel2.Size = New System.Drawing.Size(58, 17)
        Me.Nivel2.TabIndex = 118
        Me.Nivel2.TabStop = True
        Me.Nivel2.Text = "Nivel 2"
        Me.Nivel2.UseVisualStyleBackColor = True
        '
        'Nivel3
        '
        Me.Nivel3.AutoSize = True
        Me.Nivel3.Location = New System.Drawing.Point(542, 72)
        Me.Nivel3.Name = "Nivel3"
        Me.Nivel3.Size = New System.Drawing.Size(58, 17)
        Me.Nivel3.TabIndex = 117
        Me.Nivel3.TabStop = True
        Me.Nivel3.Text = "Nivel 3"
        Me.Nivel3.UseVisualStyleBackColor = True
        '
        'Nivel1
        '
        Me.Nivel1.AutoSize = True
        Me.Nivel1.Location = New System.Drawing.Point(542, 41)
        Me.Nivel1.Name = "Nivel1"
        Me.Nivel1.Size = New System.Drawing.Size(58, 17)
        Me.Nivel1.TabIndex = 116
        Me.Nivel1.TabStop = True
        Me.Nivel1.Text = "Nivel 1"
        Me.Nivel1.UseVisualStyleBackColor = True
        '
        'Fecha2
        '
        Me.Fecha2.Format = System.Windows.Forms.DateTimePickerFormat.[Short]
        Me.Fecha2.Location = New System.Drawing.Point(352, 67)
        Me.Fecha2.Name = "Fecha2"
        Me.Fecha2.Size = New System.Drawing.Size(116, 20)
        Me.Fecha2.TabIndex = 115
        '
        'Fecha1
        '
        Me.Fecha1.Format = System.Windows.Forms.DateTimePickerFormat.[Short]
        Me.Fecha1.Location = New System.Drawing.Point(352, 41)
        Me.Fecha1.MaxDate = New Date(9998, 12, 1, 0, 0, 0, 0)
        Me.Fecha1.Name = "Fecha1"
        Me.Fecha1.Size = New System.Drawing.Size(116, 20)
        Me.Fecha1.TabIndex = 114
        Me.Fecha1.Value = New Date(2012, 12, 7, 22, 14, 47, 0)
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(246, 70)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(60, 13)
        Me.Label3.TabIndex = 113
        Me.Label3.Text = "Fecha Fin :"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(246, 43)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(71, 13)
        Me.Label2.TabIndex = 112
        Me.Label2.Text = "Fecha Inicio :"
        '
        'DataGridView1
        '
        Me.DataGridView1.AllowUserToAddRows = False
        Me.DataGridView1.AllowUserToDeleteRows = False
        DataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft
        DataGridViewCellStyle3.BackColor = System.Drawing.SystemColors.Control
        DataGridViewCellStyle3.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        DataGridViewCellStyle3.ForeColor = System.Drawing.SystemColors.WindowText
        DataGridViewCellStyle3.SelectionBackColor = System.Drawing.SystemColors.Highlight
        DataGridViewCellStyle3.SelectionForeColor = System.Drawing.SystemColors.HighlightText
        DataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.[True]
        Me.DataGridView1.ColumnHeadersDefaultCellStyle = DataGridViewCellStyle3
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        DataGridViewCellStyle4.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft
        DataGridViewCellStyle4.BackColor = System.Drawing.SystemColors.Window
        DataGridViewCellStyle4.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        DataGridViewCellStyle4.ForeColor = System.Drawing.SystemColors.ControlText
        DataGridViewCellStyle4.SelectionBackColor = System.Drawing.SystemColors.Highlight
        DataGridViewCellStyle4.SelectionForeColor = System.Drawing.SystemColors.HighlightText
        DataGridViewCellStyle4.WrapMode = System.Windows.Forms.DataGridViewTriState.[False]
        Me.DataGridView1.DefaultCellStyle = DataGridViewCellStyle4
        Me.DataGridView1.Location = New System.Drawing.Point(12, 166)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.Size = New System.Drawing.Size(910, 261)
        Me.DataGridView1.TabIndex = 111
        '
        'Imprimir
        '
        Me.Imprimir.Image = CType(resources.GetObject("Imprimir.Image"), System.Drawing.Image)
        Me.Imprimir.Location = New System.Drawing.Point(670, 440)
        Me.Imprimir.Name = "Imprimir"
        Me.Imprimir.Size = New System.Drawing.Size(57, 48)
        Me.Imprimir.TabIndex = 121
        Me.Imprimir.UseVisualStyleBackColor = True
        '
        'PrintDocument1
        '
        '
        'PrintDialog1
        '
        Me.PrintDialog1.UseEXDialog = True
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(750, 475)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(49, 13)
        Me.Label4.TabIndex = 122
        Me.Label4.Text = "Usuario :"
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(395, 128)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(42, 13)
        Me.Label6.TabIndex = 124
        Me.Label6.Text = "Haber :"
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Location = New System.Drawing.Point(235, 128)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(39, 13)
        Me.Label7.TabIndex = 123
        Me.Label7.Text = "Debe :"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(109, 125)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(119, 20)
        Me.TextBox1.TabIndex = 128
        Me.TextBox1.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(39, 125)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(65, 13)
        Me.Label5.TabIndex = 127
        Me.Label5.Text = "Subcuenta :"
        '
        'Añadir
        '
        Me.Añadir.Location = New System.Drawing.Point(767, 121)
        Me.Añadir.Name = "Añadir"
        Me.Añadir.Size = New System.Drawing.Size(116, 26)
        Me.Añadir.TabIndex = 129
        Me.Añadir.Text = "Añadir"
        Me.Añadir.UseVisualStyleBackColor = True
        '
        'Fecha3
        '
        Me.Fecha3.Format = System.Windows.Forms.DateTimePickerFormat.[Short]
        Me.Fecha3.Location = New System.Drawing.Point(630, 125)
        Me.Fecha3.Name = "Fecha3"
        Me.Fecha3.Size = New System.Drawing.Size(116, 20)
        Me.Fecha3.TabIndex = 131
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Location = New System.Drawing.Point(562, 128)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(60, 13)
        Me.Label8.TabIndex = 130
        Me.Label8.Text = "Fecha Fin :"
        '
        'Debe
        '
        Me.Debe.DecimalPlaces = 2
        Me.Debe.InterceptArrowKeys = False
        Me.Debe.Location = New System.Drawing.Point(280, 125)
        Me.Debe.Maximum = New Decimal(New Integer() {10000, 0, 0, 0})
        Me.Debe.Name = "Debe"
        Me.Debe.Size = New System.Drawing.Size(109, 20)
        Me.Debe.TabIndex = 132
        Me.Debe.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Haber
        '
        Me.Haber.DecimalPlaces = 2
        Me.Haber.InterceptArrowKeys = False
        Me.Haber.Location = New System.Drawing.Point(443, 125)
        Me.Haber.Maximum = New Decimal(New Integer() {10000, 0, 0, 0})
        Me.Haber.Name = "Haber"
        Me.Haber.Size = New System.Drawing.Size(109, 20)
        Me.Haber.TabIndex = 133
        Me.Haber.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label9
        '
        Me.Label9.AutoSize = True
        Me.Label9.BackColor = System.Drawing.Color.Transparent
        Me.Label9.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label9.Location = New System.Drawing.Point(62, 90)
        Me.Label9.Name = "Label9"
        Me.Label9.Size = New System.Drawing.Size(781, 20)
        Me.Label9.TabIndex = 134
        Me.Label9.Text = ". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ." & _
    " . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ." & _
    " . . . . . . . . . . . . . . . ."
        '
        'Presupuestos
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(934, 512)
        Me.Controls.Add(Me.Label9)
        Me.Controls.Add(Me.Haber)
        Me.Controls.Add(Me.Debe)
        Me.Controls.Add(Me.Fecha3)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.Añadir)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Imprimir)
        Me.Controls.Add(Me.Mostrar)
        Me.Controls.Add(Me.Nivel4)
        Me.Controls.Add(Me.Nivel2)
        Me.Controls.Add(Me.Nivel3)
        Me.Controls.Add(Me.Nivel1)
        Me.Controls.Add(Me.Fecha2)
        Me.Controls.Add(Me.Fecha1)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.Label1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog
        Me.MaximizeBox = False
        Me.Name = "Presupuestos"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Presupuestos"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.Debe, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.Haber, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents PictureBox1 As System.Windows.Forms.PictureBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Mostrar As System.Windows.Forms.Button
    Friend WithEvents Nivel4 As System.Windows.Forms.RadioButton
    Friend WithEvents Nivel2 As System.Windows.Forms.RadioButton
    Friend WithEvents Nivel3 As System.Windows.Forms.RadioButton
    Friend WithEvents Nivel1 As System.Windows.Forms.RadioButton
    Friend WithEvents Fecha2 As System.Windows.Forms.DateTimePicker
    Friend WithEvents Fecha1 As System.Windows.Forms.DateTimePicker
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents DataGridView1 As System.Windows.Forms.DataGridView
    Friend WithEvents Imprimir As System.Windows.Forms.Button
    Friend WithEvents PrintDocument1 As System.Drawing.Printing.PrintDocument
    Friend WithEvents PrintDialog1 As System.Windows.Forms.PrintDialog
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Añadir As System.Windows.Forms.Button
    Friend WithEvents Fecha3 As System.Windows.Forms.DateTimePicker
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents Debe As System.Windows.Forms.NumericUpDown
    Friend WithEvents Haber As System.Windows.Forms.NumericUpDown
    Friend WithEvents Label9 As System.Windows.Forms.Label
End Class
