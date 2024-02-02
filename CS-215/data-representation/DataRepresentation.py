def generic_function():
    #x = bin(8)
    #x = bin(5)
    #x = bin(65)
    #x = bin(-5)
    #print("x =",x)

    #y = int(0b101)
    #y = int("0b101")
    #y = int("0b101",2)
    #y = 0b101
    #y = "0b101"
    #print("y = ",y)
    x = bin(5)
    x = x.replace("0b","")
    y = 10010111
    print(x)
    print(~y)
#generic_function()

def BinNBits(x,y):
    value = bin(x)

    if x >= 0:
        value = value.replace("0b","")
    else:
        value = value.replace("-0b","")
    if y < len(value):
        raise ValueError("Not enough bits")
    mystring2 = "-0b"
    mystring = "0b"
    zero = "0"
    for i in value:
        y = y - 1
    while y > 0:
        value = zero + value
        y = y - 1
    if x >= 0:
        value = mystring + value
    else:
        value = mystring2 + value
    #print(value)
    return value

def signedBin(num, bits):
    if num > 0:
        num = BinNBits(num,bits)
        #print(num)
        return num
    num = abs(num)
    val = bin(num)
    val = val[2:]
    string = ""
    list = []
    if len(val) > bits:
        raise ValueError("Not enough bits")
    val = val.zfill(bits)
    for i in val:
        list.append(i)
    n = 0
    m = len(val) - 1
    for i in list:
        if i == "0":
            list[n] = "1"
            n = n+1
        elif i == "1":
            list[n] = "0"
            n = n+1
    while True:
        i = int(list[m])
        i = i+1
        if i>1:
            list[m] = "0"
            m = m-1
        elif i == 1:
            list[m] = "1"
            break
    string = string.join(list)
    string = "0b" + string
    #print(string)
    return string

def signedInt(binNum):
    if "b" not in binNum:
        raise TypeError
    val = binNum[2:]
    if val[0] == "1":
        f = -1
    else:
        w = 0
        q = len(val) - 1
        for i in val:
            if i == "1":
                w = w + 2**q
                q = q-1
            elif i == "0":
                q = q-1
        #print(w)
        return w
    list = []
    for i in val:
        list.append(i)
    n = 0
    for i in list:
        if i == "0":
            list[n] = "1"
            n = n+1
        elif i == "1":
            list[n] = "0"
            n = n+1
    n = len(val)-1
    while True:
        i = int(list[n])
        i = i + 1
        if i >1:
            list[n] = "0"
            n = n-1
        elif i == 1:
            list[n] = "1"
            break
        if n == -1 and i != 1:
            break
    n = len(val) - 1
    x = 0
    for i in list:
        if i == "1":
            x = x + 2**n
            n = n-1
        elif i == "0":
            n = n - 1
    x = x*f
    #print(x)
    return x

def Binary_Addition(Bin1,Bin2):
    if "b" not in Bin1 or "b" not in Bin2:
        raise TypeError
    val1 = Bin1[2:]
    val2 = Bin2[2:]
    if len(val1) < len(val2):
        y = len(val2)
        val1 = val1.zfill(y)
    elif len(val1) > len(val2):
        x = len(val1)
        val2 = val2.zfill(x)
    list1 = []
    list2 = []
    list3 = []
    string = ""
    for i in val1:
        list1.append(i)
    for i in val2:
        list2.append(i)
    n = len(val1)-1
    carry = 0
    while True:
        i1 = int(list1[n])
        i2 = int(list2[n])
        i3 = i1 + i2 + carry
        if i3 == 3:
            list3.append("1")
            carry = 1
            n = n-1
        if i3 == 2:
            list3.append("0")
            carry = 1
            n = n-1
        if i3 == 1:
            list3.append("1")
            carry = 0
            n = n-1
        if i3 == 0:
            list3.append("0")
            carry = 0
            n = n-1
        if n == -1:
            break
    list3.reverse()
    string = string.join(list3)
    string = "0b" + string
    #print(string)
    return string
def float2bin(num):
    if abs(num) > 15.5 or abs(num) < 0.25:
        raise ValueError("exceeds the boundaries of NaN")
    if num < 0:
        signbit = "1"
    elif num >= 0:
        signbit = "0"
    val = abs(num)
    val = str(val)
    val = val.split(".")
    string2 = str(bin(int(val[0])))
    string2 = string2[2:]
    string2 = string2.zfill(3)
    item = int(val[1]) / 10**len(val[1])
    list = []
    n = 1
    while item != 0:
        mult = 0.5**n
        if mult > item:
            n = n+1
            list.append("0")
            continue
        item = item - mult
        list.append("1")
        n = n+1
    string3 = ""
    string3 = string3.join(list)
    string4 = string2 + string3

    n = 0
    if string2 == "0":
        string4 = string4[::-1]
        mantissa = string4
        radix = "000"
        binary = signbit + radix + mantissa
        return binary
    else:
        for i in string4:
            if i == "1":
                string4 = string4[n] + "." + string4[(n+1):]
                break
            else:
                n = n + 1
        string4 = string4.split(".")
        mantissa = string4[1]
    radix = len(string2) - 1
    radix = radix + radix
    radix = bin(radix)
    radix = radix[2:]
    binary = signbit + radix + mantissa
    #print(string4)
    return binary

#float2bin(15.5)
def manInt(man):
    power = -1
    mantissa = 0
    for i in man:
        mantissa += (int(i) * pow(2, power))
        power -= 1
    return (mantissa + 1)
def bin2float(binNum):
    signedbit = binNum[0]
    if signedbit == "1":
        mult = -1
    elif signedbit == "0":
        mult = 1
    mantissa = binNum[4:]
    biased_exponent = int(binNum[1:3],2)
    decimal = manInt(mantissa)
    unbiased_exponent = biased_exponent - 1
    num = mult * decimal * pow(2, unbiased_exponent)
    print(num)

#bin2float("01001110")

#