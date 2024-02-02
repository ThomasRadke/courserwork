def spaced(value):
    value = value[0:4]+" "+value[4:8]+" "+value[8:12]+" "+value[12:16]
    print(value)
#spaced("0000000000000000")
def first_register(value,list): #works for all registers just takes a three bit pattern and returns a register number
    item_1 = value[1]   #item_1 inherits the value of the remaining part of the full bit item_1 = 001000110
    item_1 = item_1[0:3]    # shortens item_1 to only include the first three characters item_1 = 001
    item_1 = item_1.split() #converts string to list originally an accident but works just as well item_1 = (001)
    for i in item_1:    # i then inherits the string as a whole don't know if for loop is necessary here
        if i == "000":
            list.append("R0")
        if i == "001":
            list.append("R1")
        if i == "010":
            list.append("R2")
        if i == "011":
            list.append("R3")
        if i == "100":
            list.append("R4")
        if i == "101":
            list.append("R5")
        if i == "110":
            list.append("R6")
        if i == "111":
            list.append("R7")
def decode(value):
    value = value[0:4] + " " + value[4:16]  #separates the first 4 bits from the rest of the string
    instructions=[] # blank list going to hold the instructions produced by the binary strings
    value = value.split()   #splits the string into a list of the first 4 bits and the rest of the string

    for i in value: #i inherits the value of the first four bits to initialize how the rest of the binary string will be used
        if i == "0000": #example for ADD 0001 110 001 000110 value = (0001,110001000110)
            instructions.append("HALT")
            #instructions.append(value[1])
        if i == "0001":
            instructions.append("ADD")
            first_register(value,instructions)  #direct register
            value = value[1] #value = 110001000110
            value = value[0:3] + " " + value[3:12] #value = 110 001000110
            value = value.split() #value = (110, 001000110)
            first_register(value,instructions)
            value = value[1]
            value = value[3:9]
            let = value[0]
            if let == "0":
                value = value[0:3] + " " + value[3:6]
                value = value.split()
                first_register(value,instructions)
            elif let == "1":
                #value = value[0:3] + " " + value[3:6]
                #value = value.split()
                instructions.append(value[1:6])
        if i == "0010":
            instructions.append("AND")
            first_register(value,instructions)
            value = value[1]
            value = value[0:3] + " " + value[3:12]
            value = value.split()
            first_register(value,instructions)
            value = value[1]
            value = value[3:9]
            let = value[0]
            if let == "0":
                value = value[0:3] + " " + value[3:6]
                value = value.split()
                first_register(value,instructions)
            elif let == "1":
                instructions.append(value[1:6])
        if i == "0011":
            instructions.append("NOT")
            first_register(value,instructions)
            value = value[1]
            value = value[0:3] + " " + value[3:12]
            value = value.split()
            first_register(value,instructions)
            value = value[1]
            instructions.append(value[3:9])
        if i == "0100":
            instructions.append("LD")
            first_register(value,instructions)
            value = value[1]
            value = value[0:3] + " " + value[3:12]
            value = value.split()
            instructions.append(value[1])
        if i == "0101":
            instructions.append("LDI")
            first_register(value,instructions)
            value = value[1]
            value = value[0:3] + " " + value[3:12]
            value = value.split()
            instructions.append(value[1])
        if i == "0110":
            instructions.append("LDR")
            first_register(value,instructions)
        if i == "0111":
            instructions.append("ST")
            first_register(value,instructions)
            value = value[1]
            value = value[0:3] + " " + value[3:12]
            value = value.split()
            instructions.append(value[1])
        if i == "1000":
            instructions.append("STI")
            first_register(value,instructions)
            value = value[1]
            value = value[0:3] + " " + value[3:12]
            value = value.split()
            instructions.append(value[1])
        if i == "1001":
            instructions.append("STR")
            first_register(value,instructions)
        if i == "1010":
            let = value[1]
            if let[3] == "0":
                instructions.append("GET")
            elif let[3] == "1":
                instructions.append("GETC")
            first_register(value,instructions)
        if i == "1011":
            let = value[1]
            if let[3] == "0":
                instructions.append("PUT")
            elif let[3] == "1":
                instructions.append("PUTC")
            first_register(value,instructions)
        if i == "1100":
            instructions.append("BR")
            value = value[1]
            value = value[0:3] + " " + value[3:12]
            value = value.split()
            let = value[0]
            if let[0] == "1":
                instructions.append("Z")
            elif let[1] == "1":
                instructions.append("N")
            elif let[2] == "1":
                instructions.append("P")
            instructions.append(value[1])
        if i == "1101":
            value = value[1]
            if value[4] == "0":
                instructions.append("JMP")
            elif value[4] == "1":
                instructions.append("JSR")
            instructions.append(value)
        if i == "1110":
            instructions.append("JMPR")
        if i == "1111":
            instructions.append("RET")
            instructions.append(value[1])
    return instructions
    #print(instructions)
#decode("0010010011000011")
#decode("1100101000111000")
#decode("0000000000000000")
def zfill(binx):
    binx = binx[2:]
    while(len(binx)<16):
        binx = "0" + binx
    return binx
def DR2(instructions,x):
    if instructions[x] == "R0":
        value = 0
    if instructions[x] == "R1":
        value = 1
    if instructions[x] == "R2":
        value = 2
    if instructions[x] == "R3":
        value = 3
    if instructions[x] == "R4":
        value = 4
    if instructions[x] == "R5":
        value = 5
    if instructions[x] == "R6":
        value = 6
    if instructions[x] == "R7":
        value = 7
    return value
def DR(instructions, registers,x):
    if instructions[x] == "R0":
        value = registers[0]
    if instructions[x] == "R1":
        value = registers[1]
    if instructions[x] == "R2":
        value = registers[2]
    if instructions[x] == "R3":
        value = registers[3]
    if instructions[x] == "R4":
        value = registers[4]
    if instructions[x] == "R5":
        value = registers[5]
    if instructions[x] == "R6":
        value = registers[6]
    if instructions[x] == "R7":
        value = registers[7]
    return value
def binary2int(binary):
    n = len(binary)
    n = n-1
    value = 0
    for i in binary:
        if i == "0":
            n=n-1
            continue
        if i == "1":
            value = value + 2**n
            n=n-1
    return value
def twos_comp(val, bits):
    if (val & (1 << (bits - 1))) != 0:
        val = val - (1 << bits)
    return val


def VM():
    on = True
    memory = ["0000000000000000"]
    # memory = memory * 10
    memory = memory * 2 ** 16
    # print(memory)
    registers = ["0000000000000000"]
    registers = registers * 8
    Instruction_pointer = "0000000000000000"
    Instruction_register = "0000000000000000"
    NZP_register = ["0","0","0"]
    while(on):
        User_input = input(">")
        User_input = User_input.upper()
        if User_input == "LOAD":
            file = open(input("FILENAME:"))
            addr = int(input("ADDRESS:"))
            Instruction_pointer = int(addr)
            x = 0
            for i in file:
                memory[addr] = i
                addr=addr+1

            #print(Instruction_pointer)

            #print(memory)
        #if User_input == "PRINT":
         #   for i in memory:
          #      print(i)
        if User_input == "DUMP":
            n = 0
            for i in memory:
                h = hex(n)
                n=n+1
                i = i[0:4]+" "+i[4:8]+" "+i[8:12]+" "+i[12:16]
                print(h,":",i)

        if User_input == "REGISTERS":
            x = 0
            for i in registers:
                i = i[0:4] + " " + i[4:8] + " " + i[8:12] + " " + i[12:16]
                print("register",x,":",i)
                x=x+1

        if User_input == "STATE":
            n = 0
            for i in memory:
                h = hex(n)
                n = n + 1
                i = i[0:4] + " " + i[4:8] + " " + i[8:12] + " " + i[12:16]
                print(h, ":", i)
            x = 0
            for i in registers:
                i = i[0:4] + " " + i[4:8] + " " + i[8:12] + " " + i[12:16]
                print("register", x, ":", i)
                x = x + 1
            print("Instruction Pointer:",Instruction_pointer)
            print("Instruction Register:",Instruction_register)
            print("NZP Register:", NZP_register)
        if User_input == "RUN":
            #registers[0] = "0000000000001010"
           # print(Instruction_pointer)
            std = True
            while std:
                Instruction_register = memory[Instruction_pointer]
                Instruction_pointer = Instruction_pointer+1
                if Instruction_pointer >= 65536:
                    break
                instructions = decode(Instruction_register)
                i = instructions[0]
                if i == "HALT":
                    break
                if i == "PUT":
                    value = DR(instructions,registers,1)
                    item = binary2int(value)
                    print(item)
                if i == "PUTC":
                    value = DR(instructions, registers,1)
                    item = binary2int(value)
                    #print(item)
                    print(chr(item))
                if i == "GET":
                    x = int(input(">>"))
                    let = x
                    if let > 0:
                        NZP_register[2] = "1"
                        NZP_register[1] = "0"
                        NZP_register[0] = "0"
                    if let == 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "1"
                        NZP_register[0] = "0"
                    if let < 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "0"
                        NZP_register[0] = "1"
                    binx = bin(x)
                    binx = zfill(binx)
                    item = DR2(instructions,1)
                    registers[item] = binx
                    #print(registers[item])

                if i == "GetC":
                    x = input(">>")
                    y = ord(x)
                    let = int(y)
                    if let > 0:
                        NZP_register[2] = "1"
                        NZP_register[1] = "0"
                        NZP_register[0] = "0"
                    if let == 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "1"
                        NZP_register[0] = "0"
                    if let < 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "0"
                        NZP_register[0] = "1"
                    biny = bin(y)
                    biny = zfill(biny)
                    item = DR2(instructions,1)
                    registers[item] = biny
                if i == "ADD":
                    value = DR(instructions, registers,2)
                    item = binary2int(value)
                    if "R" in instructions[3]:
                        value2 = DR(instructions, registers, 3)
                        item2 = binary2int(value)
                    else:
                        item2 = twos_comp(int(instructions[3],2),len(instructions[3]))
                    let = item + item2
                    if let > 0:
                        NZP_register[2] = "1"
                        NZP_register[1] = "0"
                        NZP_register[0] = "0"
                    if let == 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "1"
                        NZP_register[0] = "0"
                    if let < 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "0"
                        NZP_register[0] = "1"
                    let = bin(let)
                    let = zfill(let)
                    sti = DR2(instructions,1)
                    registers[sti] = let

                if i == "AND":
                    list = []
                    string = ""
                    register = DR2(instructions,1)
                    value = DR(instructions,registers,2)

                    if "R" in instructions[3]:
                        value2 = DR(instructions, registers, 3)
                        n = 0
                        for i in value:
                            if i == "1" and value2[n] == "1":
                                list.append("1")
                                n = n + 1
                            else:
                                list.append("0")
                                n = n + 1
                        item = DR2(instructions, 1)
                        string = string.join(list)
                        registers[item] = string
                        let = binary2int(registers[item])
                        if let > 0:
                            NZP_register[2] = "1"
                            NZP_register[1] = "0"
                            NZP_register[0] = "0"
                        if let == 0:
                            NZP_register[2] = "0"
                            NZP_register[1] = "1"
                            NZP_register[0] = "0"
                        if let < 0:
                            NZP_register[2] = "0"
                            NZP_register[1] = "0"
                            NZP_register[0] = "1"
                    else:
                        let = binary2int(instructions[3])
                        item = bin(let)
                        item = zfill(item)
                        n = 0
                        for i in value:
                            if i == "1" and item[n] == "1":
                                list.append("1")
                                n = n+1
                            else:
                                list.append("0")
                                n = n+1
                        string = string.join(list)
                        registers[register] = string
                        let = binary2int(registers[register])
                        if let > 0:
                            NZP_register[2] = "1"
                            NZP_register[1] = "0"
                            NZP_register[0] = "0"
                        if let == 0:
                            NZP_register[2] = "0"
                            NZP_register[1] = "1"
                            NZP_register[0] = "0"
                        if let < 0:
                            NZP_register[2] = "0"
                            NZP_register[1] = "0"
                            NZP_register[0] = "1"
                if i == "NOT":
                    list = []
                    string = ""
                    value = DR(instructions,registers,2)
                    for i in value:
                        if i == "1":
                            list.append("0")
                        if i == "0":
                            list.append("1")
                    string = string.join(list)
                    item = DR2(instructions,1)
                    registers[item] = string
                    let = binary2int(registers[item])
                    if let > 0:
                        NZP_register[2] = "1"
                        NZP_register[1] = "0"
                        NZP_register[0] = "0"
                    if let == 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "1"
                        NZP_register[0] = "0"
                    if let < 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "0"
                        NZP_register[0] = "1"
                if i == "LD":
                    item = binary2int(instructions[2])
                    value = DR2(instructions,1)
                    registers[value] = memory[item]
                    let = binary2int(registers[value])
                    if let > 0:
                        NZP_register[2] = "1"
                        NZP_register[1] = "0"
                        NZP_register[0] = "0"
                    if let == 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "1"
                        NZP_register[0] = "0"
                    if let < 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "0"
                        NZP_register[0] = "1"
                if i == "LDI":
                    item = DR2(instructions,1)
                    num = binary2int(instructions[2])
                    registers[item] = memory[num]
                    let = binary2int(registers[item])
                    if let > 0:
                        NZP_register[2] = "1"
                        NZP_register[1] = "0"
                        NZP_register[0] = "0"
                    if let == 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "1"
                        NZP_register[0] = "0"
                    if let < 0:
                        NZP_register[2] = "0"
                        NZP_register[1] = "0"
                        NZP_register[0] = "1"
                if i == "LDR":
                    return
                if i == "ST":
                    value = DR(instructions,registers,1)
                    item = binary2int(instructions[2])
                    memory[item] = value
                if i == "STI":
                    return
                if i == "STR":
                    return
                if i == "BR":
                    value = binary2int(instructions[2])
                    if "N" in instructions[1] and NZP_register[0] == "1":
                        Instruction_pointer = value
                    if "Z" in instructions[1] and NZP_register[1] == "1":
                        Instruction_pointer = value
                    if "P" in instructions[1] and NZP_register[2] == "1":
                        Instruction_pointer = value
                if i == "JMP":
                    value = binary2int(instructions[1])
                    Instruction_pointer = value
                if i == "JSR":
                    value = binary2int(instructions[1])
                    registers[7] = Instruction_pointer
                    Instruction_pointer = value
                if i == "JMPR":
                    return
                if i == "JSRR":
                    return
                if i == "RET":
                    insruction_pointer = registers[7]
                #return
        if User_input == "ASSEMBLE":
            file = open(input("FILENAME:"))
            file2 = open("file.eoc","w")
            labels = {}
            list2= []
            n = 0
            for x in file:
                if ";" in x[0]:
                    continue
                if "        " in x:
                    n=n+1
                    continue
                else:
                    x = x.split()
                    n = bin(n)
                    n = n[2:]
                    labels[n] = x[0]
                    list2.append(x[0])
                    n = binary2int(n)
                    n = n+1
            file.seek(0)
            for i in file:
                list = []
                string = ""
                if ";" in i[0]:
                    continue
                i = i.split()
                if i[0] in list2:
                    i.remove(i[0])
                if i[0] == ".ORIG":
                    item = i[1]
                    item = item[2:]
                    value = int(item,16)
                    address = bin(value)
                    address = zfill(address)
                    file2.write(address)
                    file2.write("\n")
                    continue
                if i[0] == ".END":
                    file2.write("0000000000000000")
                    file2.close
                    break
                if i[0] == ".SET":
                    let = item[1]
                    let = bin(int(let))
                    let = let[2:]
                    let = let.zfill(9)
                    file2.write(let)
                    file2.write("\n")
                    continue
                if i[0] == ".ASCII":
                    for n in i[1]:
                        let = ord(n)
                        let = bin(let)
                        let = zfill(let)
                        file2.write(let)
                        file2.write("\n")
                    file2.write("0000000000000000")
                if i[0] == ".FILL":
                    item = i[1]
                    item = item[2:]
                    value = int(item,16)
                    address = bin(value)
                    address = zfill(address)
                    file2.write(address)
                    file2.write("\n")
                    continue
                    list = []
                    string = ""
                if i[0] == "HALT":
                    list.append("0000000000000000")
                if i[0] == "ADD":
                    list.append("0001")
                    item0 = binary_register(i[1])
                    item2 = binary_register(i[2])
                    list.append(item0)
                    list.append(item2)
                    if "#" in i[3]:
                        list.append("1")
                        value = i[3]
                        value = value[1:]
                        value = bin(int(value))
                        value = zfill2(value)
                        list.append(value)
                    else:
                        list.append("000")
                        item3 = binary_register(i[3])
                        list.append(item3)
                if i[0] == "AND":
                    list.append("0010")
                    item0 = binary_register(i[1])
                    item2 = binary_register(i[2])
                    list.append(item0)
                    list.append(item2)
                    if "#" in i[3]:
                        list.append("1")
                        value = i[3]
                        value = value[1:]
                        value = bin(int(value))
                        value = zfill(value)
                        list.append(value)
                    else:
                        list.append("000")
                        item1 = binary_register(i[3])
                        list.append(item1)
                if i[0] == "NOT":
                    list.append("0011")
                    item0 = binary_register(i[1])
                    item2 = binary_register(i[2])
                    list.append("111111")
                if i[0] == "LD":
                    list.append("0100")
                    item0 = binary_register(i[1])
                    list.append(item0)
                    for key, value in labels.items():
                        if value == i[2]:
                            offset = key
                    offset = offset.zfill(9)
                    list.append(offset)
                if i[0] == "LDI":
                    list.append("0101")
                    item0 = binary_register(i[1])
                    list.append(item0)
                    for key, value in labels.items():
                        if value == i[2]:
                            offset = key
                    offset = offset.zfill(9)
                    list.append(offset)
                if i[0] == "ST":
                    list.append("0111")
                    item0 = binary_register(i[1])
                    list.append(item0)
                    for key, value in labels.items():
                        if value == i[2]:
                            offset = key
                    offset = offset.zfill(9)
                    list.append(offset)
                if i[0] == "STI":
                    list.append("1000")
                    item0 = binary_register(i[1])
                    list.append(item0)
                    for key, value in labels.items():
                        if value == i[2]:
                            offset = key
                    offset = offset.zfill(9)
                    list.append(offset)
                if i[0] == "GET" or i[0] == "GETC":
                    list.append("1010")
                    #  print(item)
                    item0 = binary_register(i[1])
                    let = i[0]
                    list.append(item0)
                    if let == "GETC":
                        list.append("111111111")
                    elif let == "GET":
                        list.append("011111111")
                if i[0] == "PUT" or i[0] == "PUTC":
                    list.append("1011")
                    item0 = binary_register(i[1])
                    list.append(item0)
                    if i[0] == "PUTC":
                        list.append("111111111")
                    elif i[0] == "PUT":
                        list.append("011111111")
                if i[0] == "BR":
                    list.append("1100")
                    if "N" in i[1]:
                        list.append("1")
                    else:
                        list.append("0")
                    if "Z" in i[1]:
                        list.append("1")
                    else:
                        list.append("0")
                    if "P" in i[1]:
                        list.append("1")
                    else:
                        list.append("0")
                    for key, value in labels.items():
                        if value == i[2]:
                            offset = key
                    offset = offset.zfill(9)
                    list.append(offset)
                if i[0] == "JMP" or i[0] == "JSR":
                    list.append("1101")
                    if i[0] == "JSR":
                        list.append("1")
                    if i[0] == "JMP":
                        list.append("0")
                    list.append("00")
                    for key, value in labels.items():
                        if value == i[1]:
                            offset = key
                    offset = offset.zfill(9)
                    list.append(offset)
                if i[0] == "RET":
                    list.append("1111000000000000")
                string = string.join(list)
                file2.write(string)
                file2.write("\n")
            file.close()
            file2.close()
        if User_input == "EXIT":
            on = False
def binary_register(reg):
    if reg == "R0":
        item = "000"
    if reg == "R1":
        item = "001"
    if reg == "R2":
        item = "010"
    if reg == "R3":
        item = "011"
    if reg == "R4":
        item = "100"
    if reg == "R5":
        item = "101"
    if reg == "R6":
        item = "110"
    if reg == "R7":
        item = "111"
    return item
def zfill2(binx):
    binx = binx[2:]
    while(len(binx)<5):
        binx = "0" + binx
    return binx
# def recode(item):
#     list = []
#     string = ""
#     if item[0] == "HALT":
#         list.append("0000000000000000")
#     if item[0] == "ADD":
#         list.append("0001")
#         item0 = binary_register(item[1])
#         item2 = binary_register(item[2])
#         list.append(item0)
#         list.append(item2)
#         if "#" in item[3]:
#             list.append("1")
#             value = item[3]
#             value = value[1:]
#             value = bin(int(value))
#             value = zfill2(value)
#             list.append(value)
#         else:
#             list.append("000")
#             item3 = binary_register(item[3])
#             list.append(item3)
#     if item[0] == "AND":
#         list.append("0010")
#         item0 = binary_register(item[1])
#         item2 = binary_register(item[2])
#         list.append(item0)
#         list.append(item2)
#         if "#" in item[3]:
#             list.append("1")
#             value = item[3]
#             value = value[1:]
#             value = bin(int(value))
#             value = zfill(value)
#             list.append(value)
#         else:
#             list.append("000")
#             item1 = binary_register(item[3])
#             list.append(item1)
#     if item[0] == "NOT":
#         list.append("0011")
#         item0 = binary_register(item[1])
#         item2 = binary_register(item[2])
#         list.append("111111")
#     if item[0] == "LD":
#         list.append("0100")
#         item0 = binary_register(item[1])
#         list.append(item0)
#     if item[0] == "LDI":
#         list.append("0101")
#         item0 = binary_register(item[1])
#         list.append(item0)
#     if item[0] == "ST":
#         list.append("0111")
#         item0 = binary_register(item[1])
#         list.append(item0)
#     if item[0] == "STI":
#         list.append("1000")
#         item0 = binary_register(item[1])
#         list.append(item0)
#         list.append(item[2])
#     if item[0] == "GET" or item[0] == "GETC":
#         list.append("1010")
#       #  print(item)
#         item0 = binary_register(item[1])
#         let = item[0]
#         list.append(item0)
#         if let == "GETC":
#             list.append("111111111")
#         elif let == "GET":
#             list.append("011111111")
#     if item[0] == "PUT" or item[0] == "PUTC":
#         list.append("1011")
#         item0 =  binary_register(item[1])
#         list.append(item0)
#         if item[0] == "PUTC":
#             list.append("111111111")
#         elif item[0] == "PUT":
#             list.append("011111111")
#     if item[0] == "BR":
#         list.append("1100")
#         if "N" in item[1]:
#             list.append("1")
#         else:
#             list.append("0")
#         if "Z" in item[1]:
#             list.append("1")
#         else:
#             list.append("0")
#         if "P" in item[1]:
#             list.append("1")
#         else:
#             list.append("0")
#         list.append(item[2])
#     if item[0] == "JMP" or item[0] == "JSR":
#         list.append("1101")
#         if item[0] == "JSR":
#             list.append("1")
#         if item[0] == "JMP":
#             list.append("0")
#     if item[0] == "RET":
#         list.append("1111000000000000")
#     string = string.join(list)
#     return string
VM()