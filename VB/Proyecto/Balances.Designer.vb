<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Balances
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Balances))
        Dim DataGridViewCellStyle3 As System.Windows.Forms.DataGridViewCellStyle = New System.Windows.Forms.DataGridViewCellStyle()
        Dim DataGridViewCellStyle4 As System.Windows.Forms.DataGridViewCellStyle = New System.Windows.Forms.DataGridViewCellStyle()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.Fecha2 = New System.Windows.Forms.DateTimePicker()
        Me.Fecha1 = New System.Windows.Forms.DateTimePicker()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Nivel1 = New System.Windows.Forms.RadioButton()
        Me.Nivel3 = New System.Windows.Forms.RadioButton()
        Me.Nivel2 = New System.Windows.Forms.RadioButton()
        Me.Nivel4 = New System.Windows.Forms.RadioButton()
        Me.Mostrar = New System.Windows.Forms.Button()
        Me.Imprimir = New System.Windows.Forms.Button()
        Me.PrintDocument1 = New System.Drawing.Printing.PrintDocument()
        Me.PrintDialog1 = New System.Windows.Forms.PrintDialog()
        Me.Label4 = New System.Windows.Forms.Label()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
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
        Me.Label1.Location = New System.Drawing.Point(101, 38)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(77, 18)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Balances"
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
        Me.DataGridView1.Location = New System.Drawing.Point(37, 166)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.Size = New System.Drawing.Size(860, 261)
        Me.DataGridView1.TabIndex = 34
        '
        'Fecha2
        '
        Me.Fecha2.Format = System.Windows.Forms.DateTimePickerFormat.[Short]
        Me.Fecha2.Location = New System.Drawing.Point(333, 62)
        Me.Fecha2.Name = "Fecha2"
        Me.Fecha2.Size = New System.Drawing.Size(116, 20)
        Me.Fecha2.TabIndex = 105
        '
        'Fecha1
        '
        Me.Fecha1.Format = System.Windows.Forms.DateTimePickerFormat.[Short]
        Me.Fecha1.Location = New System.Drawing.Point(333, 36)
        Me.Fecha1.Name = "Fecha1"
        Me.Fecha1.Size = New System.Drawing.Size(116, 20)
        Me.Fecha1.TabIndex = 104
        Me.Fecha1.Value = New Date(2010, 1, 1, 0, 0, 0, 0)
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(212, 69)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(60, 13)
        Me.Label3.TabIndex = 103
        Me.Label3.Text = "Fecha Fin :"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(212, 42)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(71, 13)
        Me.Label2.TabIndex = 102
        Me.Label2.Text = "Fecha Inicio :"
        '
        'Nivel1
        '
        Me.Nivel1.AutoSize = True
        Me.Nivel1.Location = New System.Drawing.Point(543, 36)
        Me.Nivel1.Name = "Nivel1"
        Me.Nivel1.Size = New System.Drawing.Size(58, 17)
        Me.Nivel1.TabIndex = 106
        Me.Nivel1.TabStop = True
        Me.Nivel1.Text = "Nivel 1"
        Me.Nivel1.UseVisualStyleBackColor = True
        '
        'Nivel3
        '
        Me.Nivel3.AutoSize = True
        Me.Nivel3.Location = New System.Drawing.Point(543, 67)
        Me.Nivel3.Name = "Nivel3"
        Me.Nivel3.Size = New System.Drawing.Size(58, 17)
        Me.Nivel3.TabIndex = 107
        Me.Nivel3.TabStop = True
        Me.Nivel3.Text = "Nivel 3"
        Me.Nivel3.UseVisualStyleBackColor = True
        '
        'Nivel2
        '
        Me.Nivel2.AutoSize = True
        Me.Nivel2.Location = New System.Drawing.Point(621, 36)
        Me.Nivel2.Name = "Nivel2"
        Me.Nivel2.Size = New System.Drawing.Size(58, 17)
        Me.Nivel2.TabIndex = 108
        Me.Nivel2.TabStop = True
        Me.Nivel2.Text = "Nivel 2"
        Me.Nivel2.UseVisualStyleBackColor = True
        '
        'Nivel4
        '
        Me.Nivel4.AutoSize = True
        Me.Nivel4.Location = New System.Drawing.Point(621, 69)
        Me.Nivel4.Name = "Nivel4"
        Me.Nivel4.Size = New System.Drawing.Size(104, 17)
        Me.Nivel4.TabIndex = 109
        Me.Nivel4.TabStop = True
        Me.Nivel4.Text = "Nivel Subcuenta"
        Me.Nivel4.UseVisualStyleBackColor = True
        '
        'Mostrar
        '
        Me.Mostrar.Location = New System.Drawing.Point(767, 58)
        Me.Mostrar.Name = "Mostrar"
        Me.Mostrar.Size = New System.Drawing.Size(116, 26)
        Me.Mostrar.TabIndex = 110
        Me.Mostrar.Text = "Mostrar"
        Me.Mostrar.UseVisualStyleBackColor = True
        '
        'Imprimir
        '
        Me.Imprimir.Image = CType(resources.GetObject("Imprimir.Image"), System.Drawing.Image)
        Me.Imprimir.Location = New System.Drawing.Point(670, 440)
        Me.Imprimir.Name = "Imprimir"
        Me.Imprimir.Size = New System.Drawing.Size(57, 48)
        Me.Imprimir.TabIndex = 111
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
        Me.Label4.TabIndex = 112
        Me.Label4.Text = "Usuario :"
        '
        'Balances
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(934, 512)
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
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.MaximizeBox = False
        Me.Name = "Balances"
        Me.ShowIcon = False
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Balances"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents PictureBox1 As System.Windows.Forms.PictureBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents DataGridView1 As System.Windows.Forms.DataGridView
    Friend WithEvents Fecha2 As System.Windows.Forms.DateTimePicker
    Friend WithEvents Fecha1 As System.Windows.Forms.DateTimePicker
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Nivel1 As System.Windows.Forms.RadioButton
    Friend WithEvents Nivel3 As System.Windows.Forms.RadioButton
    Friend WithEvents Nivel2 As System.Windows.Forms.RadioButton
    Friend WithEvents Nivel4 As System.Windows.Forms.RadioButton
    Friend WithEvents Mostrar As System.Windows.Forms.Button
    Friend WithEvents Imprimir As System.Windows.Forms.Button
    Friend WithEvents PrintDocument1 As System.Drawing.Printing.PrintDocument
    Friend WithEvents PrintDialog1 As System.Windows.Forms.PrintDialog
    Friend WithEvents Label4 As System.Windows.Forms.Label
End Class
