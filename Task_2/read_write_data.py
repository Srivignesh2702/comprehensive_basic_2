import csv

class ReadAndWriteData:
    def __init__(self, file_path):
        self.file_path = file_path
        self.data = []

    def read_data_from_csv(self):
        with open(self.file_path, 'r', newline='') as csvfile:
            reader = csv.DictReader(csvfile)
            for row in reader:
                self.data.append(row)

    def display_data(self):
        for row in self.data:
            print(row)

# Create an instance of ReadAndWriteData and read data from CSV file
data_processor = ReadAndWriteData('data.csv')
data_processor.read_data_from_csv()

# Display the data
data_processor.display_data()
