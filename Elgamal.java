class Elgamal():
    pub_key = 0
    pub_key2 = 0
    private_key = 0
    open_key = 0
    opponent_key = 0
    msg = 0
    r = 0

    def __init__(self, pub_key1, pub_key2, private_key):
        self.pub_key = pub_key1
        self.pub_key2 = pub_key2
        self.private_key = private_key

    def make_open_key(self):
        self.open_key = pow(self.pub_key2, self.private_key) % self.pub_key
        print("Открытый ключ = " + str(self.open_key))

    def make_msg(self, msg):
        self.r = pow(self.pub_key2,self.private_key) % self.pub_key
        print("Ваш 'R' = " + str(self.r))
        self.msg = msg * pow(self.opponent_key, self.private_key) % self.pub_key
        print("Ваш 'ENC' номер = " + str(self.msg))

    def enc_msg(self, r, e):
        e_msg = e * pow(r,self.pub_key-1-self.private_key) % self.pub_key
        print("Плученное сообщение = "+ str(e_msg))


pub_key1 = int(input("Введите открытый ключ 1: "))
pub_key2 = int(input("Введите открытый ключ 2: "))
private_key = int(input("Введите ваш закрытый ключ: "))
p1 = EG(pub_key1, pub_key2, 3)
p1.make_open_key()
p2 = EG(pub_key1, pub_key2, private_key)
p2.opponent_key = p1.open_key
msg = int(input("Введите номер для отправки: "))
p2.make_msg(msg)
p1.enc_msg(p2.r, p2.msg)
