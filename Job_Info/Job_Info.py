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

import requests
from bs4 import BeautifulSoup
from File_Management import *


# *** Can not scrape Google! ***
#

# Two Sigma:



def jobScraping():
    company_name='Two Sigma'
    general = company_name + '_General.txt'  # Name & Relative Path
    requirement = company_name + '_Requirement.txt'
    page =1
    url='https://careers.twosigma.com/careers/SearchJobs/?jobOffset=0' # initial page to start
    while True:
        source_code = requests.get(url)
        plain_text = source_code.text
        soup = BeautifulSoup(plain_text,'lxml')
        page+=1

        # General Info, include websites&job titles
        for link in soup.findAll('a',{'class':'mobileHide'}):
            href = link.get('href')
            print(href)
            title = link.string
            print(title)
            append_to_file('Resources/'+general,title)
            append_to_file('Resources/'+general,href)

        if checkPageEnd(soup)==True:
            break

        url = 'https://careers.twosigma.com/careers/SearchJobs/?jobOffset=' + str((page - 1) * 10)

    print('End of Program')

def checkPageEnd(soup):
    for number in soup.findAll('a',{'class': 'paginationItem'}):
        if number.string=='Next >>':
            return False
    return True


jobScraping()
