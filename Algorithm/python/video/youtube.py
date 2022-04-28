import pytube

url = 'https://www.youtube.com/watch?v=HxixXkpuQBU&list=RDMMHxixXkpuQBU&start_radio=1'

youtube = pytube.YouTube(url)
video = youtube.streams.first()
video.download('./Video')