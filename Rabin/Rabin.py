import prime

def encryption(plaintext, n):
    plaintext = padding(plaintext)
    return plaintext ** 2 % n


def padding(plaintext):
    binary_str = bin(plaintext)     
    output = binary_str + binary_str[-16:]      
    return int(output, 2)       

def decryption(a, p, q):
    n = p * q
    r, s = 0, 0
    if p % 4 == 3:
        r = prime.sqrt_p_3_mod_4(a, p)
    elif p % 8 == 5:
        r = prime.sqrt_p_5_mod_8(a, p)
    if q % 4 == 3:
        s = prime.sqrt_p_3_mod_4(a, q)
    elif q % 8 == 5:
        s = prime.sqrt_p_5_mod_8(a, q)

    gcd, c, d = prime.egcd(p, q)
    x = (r * d * q + s * c * p) % n
    y = (r * d * q - s * c * p) % n
    lst = [x, n - x, y, n - y]

    plaintext = choose(lst)
    string = bin(plaintext)
    string = string[:-16]
    plaintext = int(string, 2)

    return plaintext


def choose(lst):

    for i in lst:
        binary = bin(i)
        append = binary[-16:]   
        binary = binary[:-16]  
        if append == binary[-16:]:
            return i
    return
