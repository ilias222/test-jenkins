# переключить скрипт на другую кодировку консоли
# -*- coding: utf-8 -*-

import os
import time
from sys import argv

# Путь к директории
constPatch = argv[1]
# Локальное время - год
localYar = time.mktime(time.localtime())

#--------- Создание списка файлов и папок директории ----------
try:
    listFile = os.listdir(constPatch)
except:
    # Сюда попали если ввели путь к папки с пробелом
    call = len(argv)

    for call in range(2, call):
        constPatch += ' ' + argv[call]

    listFile = os.listdir(constPatch)
    

#---------- Сортировка и вывод -----------------
for item in listFile:
    try:
        # Год создания объекта (файла/папки)
        oldYar = time.localtime(os.path.getctime(os.path.join(constPatch, item)))

        # Если объект папка и она старше года
        if os.path.isdir(os.path.join(constPatch, item)) and int((localYar - time.mktime(oldYar)) / 31536000):
            print(item)
    except:
        # Сюда попали если файл в данное время не активен
        print('net ebuchego fails blyad')
        continue