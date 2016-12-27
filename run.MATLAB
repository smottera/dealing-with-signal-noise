clc;
clear;

%----Setting up Inputs-------
noisy = csvread('M2_Dataset_NoisyCalibration.txt'); 
noisy_data = noisy(:,2);
time = 1:200;


%----Calulation of Slopes at all possible points------
counter_1 = 1;
while(counter_1 < 200)
    noisy_slope(counter_1) = (noisy_data(counter_1 + 1) - noisy_data(counter_1));
    counter_1 = counter_1 + 1; 
    
end

ts_noisy = find(noisy_slope == max(noisy_slope));
ys_noisy = noisy_data(ts_noisy);

%Actual Data is data exclusive of delay 
actual_Data = noisy(ts_noisy:length(noisy))
plot(time,noisy_data,'g-');
hold on;
plot(ts_noisy,ys_noisy,'*r');
hold on;
plot(0,ys_noisy,'*r');
hold on;
text(ts_noisy, ys_noisy, '*t_s');
text(0, ys_noisy, '*y_s');
xlabel('Time');
ylabel('Temperature(Degree C)');
title('Thermocouple Temp vs. Time');
grid on;
x = 1 - exp(-1);
max(actual_Data)
min(actual_Data)

%Finding the median of stable data points....
%twenty_percent is twenty percent of the last data points
counter_2 = (round(0.8*length(noisy_data)));
counter_3 = 1;
while(counter_2 < length(noisy_data))
    twenty_percent(counter_3) = noisy_data(counter_2);
    counter_2 = counter_2 + 1;
    counter_3 = counter_3 + 1;
end
y_ss = mean(twenty_percent);



%Finding closest value of Tau
tau = x*(y_ss - ys_noisy)
temp_noisy_data = abs(noisy_data - y_ss);
temp_yss_in_data = (min(temp_noisy_data));
index_of_temp_yss = find(temp_noisy_data == temp_yss_in_data);
actual_yss = noisy_data(index_of_temp_yss);
text(index_of_temp_yss, actual_yss, '*y_s_s');
