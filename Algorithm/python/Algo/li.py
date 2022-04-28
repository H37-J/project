import smtplib

server = smtplib.SMTP('localhost')
server.sendmail('jay.ho@orangedigit.com', 'test', 'test', 'test')
