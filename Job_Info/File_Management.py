import os


def create_project_dic(directory):
    '''Create Resources Folder that handles all the files for companies'''
    if not os.path.exists(directory):
        print('Creating project '+directory)
        os.makedirs(directory)


def create_data_files(company_name):
    '''Create the two files needed for each company'''
    general = company_name + '_General.txt'  # Name & Relative Path
    requirement = company_name + '_Requirement.txt'
    if not os.path.isfile(general):
        write_file('Resources/'+general,'')
    if not os.path.isfile(requirement):
        write_file('Resources/'+requirement,'')


def write_file(path,data):
    f = open(path,'w')  # w means write
    f.write(data)
    f.close()


def append_to_file(path,data):
    '''Add data onto an existing file'''
    with open(path,'a') as file:  # a means append
        file.write(data +'\n')


def delete_file_contents(path):
    '''Delete the contents of a file'''
    with open(path,'w'):
        pass   # do nothing



create_project_dic('Resources')
create_data_files('Two Sigma')