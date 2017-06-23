'''Idea:
build a web crawler to collect the job information from big companies
(without multiple domains involved)
call the function each companies collected [like: getJobs(companyUrl)
put the urls into a dictionary with keys being the company name and values being the urls '''

import requests
from bs4 import BeautifulSoup

# *** Can not scrape Google! ***

def jobScraping(max_page):
    page=1
    while(page <= max_page):
        url = 'https://careers.twosigma.com/careers/SearchJobs/internship'
        source_code = requests.get(url)
        plain_text = source_code.text
        soup = BeautifulSoup(plain_text,'lxml')
        for link in soup.findAll('a',{'class':'mobileHide'}):
            href = link.get('href')
            #print(href)
            #title = link.string
            #print(title)
            get_requirement(href)
            print()
        page+=1


def get_requirement(single_url):
    source_code = requests.get(single_url)
    plain_text = source_code.text
    soup = BeautifulSoup(plain_text, 'lxml')
    for item in soup.findAll('font'):
        require = item.string
        print(require)

# crawl the page in that page (recursive)
    for link in soup.findAll('a'):
        href = link.get('href')
        print(href)


jobScraping(1)
#get_requirement('https://careers.twosigma.com/careers/DashJobDetail/New-York-New-York-United-States-Software-Engineering-Internship/2944')
