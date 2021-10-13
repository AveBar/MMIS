import Prime
import Rabin


def delete_space(string):
    lst = string.split(' ')
    output = ''
    for i in lst:
        output += i
    return output


def add_space(string):
    string = string[::-1]
    string = ' '.join(string[i:i + 8] for i in range(0, len(string), 8))
    return string[::-1]


if __name__ == '__main__':

    print('<Miller-Rabin>')
    print(add_space(format(prime.generate_a_prime_number(256), 'x')))

    print('\n<Rabin Encryption>')

    p = int(delete_space(input('p = ')), 16)  
    q = int(delete_space(input('q = ')), 16)   
    n = p*q
    print('n = pq =', add_space(format(n, 'x')))

    plaintext = int(delete_space(input('Plaintext = ')), 16)   
    ciphertext = Rabin.encryption(plaintext, n)
    print('Ciphertext =', add_space(format(ciphertext, 'x')))

    print('\n<Rabin Decryption>')
    ciphertext = int(delete_space(input('Ciphertext = ')), 16)    
    print('Private Keys :')
    p = int(delete_space(input('p = ')), 16)  
    q = int(delete_space(input('q = ')), 16)  
    plaintext = Rabin.decryption(ciphertext, p, q)
    print('Plaintext =', add_space(format(plaintext, 'x').zfill(226 // 4)))
