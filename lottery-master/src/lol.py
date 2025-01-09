import pickle
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np
from mpl_toolkits.mplot3d import Axed3D
import statsmodels.api as sm
from statmodels.stats.outliers_influence import variance_inflation_factor

# Setting up the plot syle
plt.style.use('seaborn-v0_8')

#Load the dataset
file_path = 'assgnmt01_student_performance_dataset.csv'
df = pd.read_csv(file_path)



# Imputation Strategies for original features

# Mean Imputation for continuous numerical features
df['study_hours-per-week'].fillna(df['study_hours_per_week'].mean(), inplace=True)