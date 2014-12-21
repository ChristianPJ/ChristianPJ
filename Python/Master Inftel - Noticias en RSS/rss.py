#!/usr/bin/env python2
# -*- coding: UTF-8 -*-

# Christian Pareja Jensen - Master Inftel

import feedparser
import time
import sys
import re

lista = []

# (Opcional: Limpia <tags>)
TAG_RE = re.compile(r'<[^>]+>')
def remove_tags(text):
    return TAG_RE.sub('', text)

def Imprimir():
	f = open(sys.argv[2],"w")
	for k in range(len(lista)):		
		f.write("<ID>\n")
		f.write(str(lista[k][0])+"\n")
		f.write("</ID>\n")
		f.write("<TITULAR>\n")
		f.write(lista[k][1].encode('utf-8', 'ignore')+"\n")
		f.write("</TITULAR>\n")
		f.write("<DESCRIPCION>\n")
		tag = remove_tags(lista[k][2].encode('utf-8', 'ignore')) 
		f.write(tag+"\n")
		f.write("</DESCRIPCION>\n")
		f.write("<ENLACE>\n")
		f.write(lista[k][3].encode('utf-8', 'ignore')+"\n")
		f.write("</ENLACE>\n")
		f.write("<ORIGEN>\n")
		f.write(lista[k][4].encode('utf-8', 'ignore')+"\n")
		f.write("</ORIGEN>\n")
		f.write("<FECHA>\n")
		f.write(lista[k][5].encode('utf-8', 'ignore')+"\n")
		f.write("</FECHA>\n")
		f.write("<RELACIONADAS>\n")
		r = ', '.join(lista[k][6])
		f.write(r+"\n")
		f.write("</RELACIONADAS>\n")
		f.write("\n")
	f.close()

if len(sys.argv) != 3:
        print "Este programa necesita dos ficheros como parametros";

else:

	flujo = open (sys.argv[1])
	linea = flujo.readline()

	id = 1 # Indice noticias

	while (len(linea)>0):
		d = feedparser.parse(linea)
		for i in range(len(d['entries'])):
			iguales = False
			for j in range (len(lista)): 
				if ((d['entries'][i]['title'] == lista[j][1]) and (d['entries'][i].author_detail.name == lista[j][4])): # Compruebo que ya exista
					iguales = True	
			if(iguales == False):
				l = []
				l.append(id)
				id += 1
				if (d['entries'][i].has_key("title")):
					l.append(d['entries'][i].title)
				else:
					l.append('-')

				if (d['entries'][i].has_key("description")):
					l.append(d['entries'][i].description)
				else:
					l.append('-')

				if (d['entries'][i].has_key("link")):
					l.append(d['entries'][i].link)
				else:
					l.append('-')

				if (d['entries'][i].has_key("author")):
					l.append(d['entries'][i].author)
				else:
					l.append('-')

				if (d['entries'][i].has_key("published_parsed")):
					l.append(time.strftime("%Y-%m-%d",d['entries'][i].published_parsed)) # Fecha
				else:
					l.append('-')

				rel = []
				l.append(rel) # Relacionadas, inicialmente vacio
				lista.append(l)	

		linea = flujo.readline() # Leo de la siguiente direccion RSS

	Imprimir()



