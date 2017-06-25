'''Initial Idea:
build a web crawler to collect the job information from big companies
(without multiple domains involved)
call the function each companies collected [like: getJobs(companyUrl)
put the urls into a dictionary with keys being the company name and values being the urls '''

'''Revised Idea:
Collect job information from companies' websites and put them into files
each company with two files:
one file with general information like Title and Websites 
another file with specific requirements'''

'''Second Revised Idea: Use Database not files - MongoDB'''


import requests
from bs4 import BeautifulSoup
from urllib.request import urlopen
from urllib.request import urlparse
import re

# *** Can not scrape Google! ***
#

# Two Sigma:

def jobScraping(url):
    page =1
    #url='https://careers.twosigma.com/careers/SearchJobs/?3_33_3=%5B%22897%22%5D&jobOffset=0' # initial page to start
    while True:
        html = urlopen(url)
        soup = BeautifulSoup(html,'lxml')
        page+=1

        # General Info, include websites&job titles
        for link in soup.findAll('a',{'class':'mobileHide'}):
            href = link.get('href')
            href = href.replace('Dash', '')
            print(href)
            title = link.string
            print(title)

            getRequirement(href)

            # TODO: Put all data into database
        if checkPageEnd(soup)==True:
            break

        #url = 'https://careers.twosigma.com/careers/SearchJobs/?jobOffset=' + str((page - 1) * 10)
        url = 'https://careers.twosigma.com/careers/SearchJobs/?3_33_3=%5B%22897%22%5D&jobOffset=' + str((page - 1) * 10)
    print('End of Program')

def checkPageEnd(soup):
    for number in soup.findAll('a',{'class': 'paginationItem'}):
        if number.string=='Next >>':
            return False
    return True


def getRequirement(url):
    # TODO: Find (Print) the requirements for each job - Finished !
    html = urlopen(url)
    soup = BeautifulSoup(html, 'lxml')

    if(soup.find(text='Requirements Include:')!=None):
        start = soup.find(text='Requirements Include:')
    else:
        start = soup.find(text=re.compile('[a-z]* qualifications')) #Handles other cases like 'Minimum Requirements'

    print('Requirements Include: ')

    requirements = start.find_next('ul').findAll('li')
    for requirement in requirements:
        print(requirement.text)

    print('\n')


execution_trading ='https://careers.twosigma.com/careers/SearchJobs/?3_33_3=%5B%22897%22%5D&jobOffset=0'

jobScraping(execution_trading)
