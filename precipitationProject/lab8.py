'''
Nicholas Letarte
001021234
CS 5001
Lab 8: Yearly precipitation in Portand with Exception Handling
'''
def round(n):
    #we must use the return function since we are calling this function elsewhere. Otherwise there will be no value.
    return int(n * 1000) / 1000 #gets average value to stop at 3 decimal places. 
                                #top value converted to an int so no more float! then when divided by 1000, goes back to a decimal point 
    
def get_avg(list_num):
    
    if len(list_num) == 0 : return 0 #if a list with a length of 0 comes in, return 0 
    #exception to be raised if parameter is not a list
    if type(list_num) != list: raise TypeError('Average values must be calculated from a list.') 
    #to be used in for loop to capture total value   
    total = 0.0
    #for each individual element in the parameter list_num....
    for i in list_num:
        total += i  #this is how we get the total from each list index  

    return round(total/ len(list_num)) #calculates average while simultaneously rounding to three decimal points



def print_avgs(data, city, starting_year,out_file_name):
    #exceptions to be raised if parameters incorrect
    if type(data) != list: raise TypeError('I was expecting a list for data parameter.')
    if type(city) != str: raise TypeError('I was expecting a string for city parameter.')
    if type(starting_year) != int: raise TypeError('I was expecting a integer for starting year parameter.')
    if type(out_file_name) != str: raise TypeError('I was expecting a string for out_file_name parameter.')
    #header for file. Must be outside of loop because I only want this written once.
    header = city + " Average Rainfall: \n" #\n tells it to start at a new line
    out_file = open(out_file_name, 'w') # out_file is defined as opening the paramter out_file_name
    out_file.write(header) #writes header, notice the location outside the loop

    for i in range(len(data)): #this goes over each element in the entire portland_data
        yearly_avg = get_avg(data[i]) #getting average from each individual index of portland_data
        current_year = starting_year + i #our starting year = 2010, as entered in parameter in main. since i is an index value, it will correspond to the year.
        out_file.write(str(current_year) + ' : ' + str(yearly_avg ) + '\n')#writes a line, then drops below to make a new one


    out_file.close() #close the file after it has been through the loop.
    
    


def main():

    try:

        file_input = input('Please enter a .csv file: ') #how we enter which file name

        if file_input.endswith('.csv') == False: #conditional statement making sure file is in csv format
            raise ValueError()#error to be raised 
        file = open(file_input,'r')# open file that was input as a string, returns a string of string 

        portland_data = [[],[],[],[],[],[],[],[],[],[],[]] #setting up to capture precip data from 2010-2020 
        lines_skipped = 0 #This will collect how many lines of data were skipped
        # data_list = []
        for row in file:

            #csv file still string
            str_clean = row.replace("\"", "")
            #converts input file to list 
            data_list = str_clean.split(",") #(temp list)
               
            try:
                #conditional statement that specifies where to collect data from for portland_data
                if data_list[1] == 'PORTLAND 5.5 WNW' and not data_list[3].startswith('2021'): 
                    year = int(data_list[3].split('-')[0])#we turn the string from index 3 to an integer, and we split the values that have a -
                    portland_data[year-2010].append(float(data_list[9]) ) #the first portion is how we index each list properly. Second portion allows us to add float data to the list


            except ValueError:
                lines_skipped += 1 

        out_file_name = input('Please enter output file name: ') #Now that values are saved, we want to get the output file named       
        print_avgs(portland_data, 'Portland', 2010, out_file_name) #
        print('Lines of Data Skipped = ' + str(lines_skipped))   
# more exceptions yay!
    except ValueError as ve:
        print('That is not a .csv file')
        print(ve)
    except FileNotFoundError as fe:
        print('This file does not exist.')
        print(fe)
    except TypeError as te:
        print("TypeError occurred")
        print(te)
    

main()





