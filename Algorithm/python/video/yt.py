import pytube
import os
import subprocess

url = 'https://www.youtube.com/watch?v=9uhUmjANdQA&list=RDMMHxixXkpuQBU&index=7'

yt = pytube.YouTube(url)

vi=yt.streams.all();

for i in range(len(vi)):
    print(i,'. ',vpipi[i])

vnum=int(input("다운받을 화질을 선택하세요"))

parent_dir="./video"
vi[vnum].download(parent_dir)

# new_filename=input("변환할 mp3명을 입력해주세요")

# default_filename=vi[vnum].default_filename

# subprocess.call(['ffmpeg','-i',
# os.path.join(parent_dir,default_filename),
# os.path.join(parent_dir,new_filename)
# ])

print('작업완료')


#mp4a.40.2 만 오디오를 가짐