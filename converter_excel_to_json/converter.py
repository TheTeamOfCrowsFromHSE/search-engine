import pandas as pd
def giveJSON(file_names_arr):
    for i in range(len(file_name_arr)):
        JSON_data = pd.read_excel(file_name_arr[i])
        file = open(str(file_name_arr[i][:-5])+'.json', "w",encoding='utf-8')
        file.write(JSON_data)
        file.close()



