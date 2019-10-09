#!/usr/bin/python3
from fpdf import FPDF

pdf=FPDF()

pdf.add_page()
pdf.add_font('fireflysung','','./fireflysung.ttf', uni=True)
pdf.set_font('fireflysung','',14)
pdf.write(8, u'Hello World!Huxing我是胡兴')
pdf.output('test.pdf','F')
