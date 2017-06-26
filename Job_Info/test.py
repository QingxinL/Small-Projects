from bs4 import BeautifulSoup
from urllib.request import urlopen
import re


#url = 'https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Electronic-Algorithmic-Trader-Campus-Hire/723'
#url='https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Software-Engineering-Internship/2944'
#url='https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Full-Stack-Analytics-Engineer/1046'
#url='https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Quantitative-Researcher-in-Machine-Learning/1439'
url ='https://careers.twosigma.com/careers/JobDetail/London-UK-United-Kingdom-Software-Engineer/390'
html = urlopen(url)
soup = BeautifulSoup(html, 'lxml')
#
# if (soup.find(text='Requirements Include:') != None):
#     start = soup.find(text='Requirements Include:')
# else:
#     start = soup.find(text=re.compile('[a-z]* qualifications'))  # Handles other cases like 'Minimum Requirements'
#
# # print('Requirements Include: ')
#
# requirements = start.find_next('ul').findAll('li')
# text = ''
# for requirement in requirements:
#     text = text + requirement.text +'\n'
#
# print(text)
loc = soup.find('p', {'itemprop': 'jobLocation'})
print(loc.text)