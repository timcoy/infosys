INSERT INTO user (id, name) VALUES
 (11, 'John Smith');

INSERT INTO account (id, number, name, account_type, balance_date, currency, balance) VALUES
 (101, '585309209', 'SGSavings726', 'Savings', {ts '2018-11-08'}, 'SGD', 84327.51),
 (102, '791066619', 'AUSavings993', 'Savings', {ts '2018-11-08'}, 'AUD', 88005.93);
 
INSERT INTO user_accounts (user_id, accounts_id) VALUES
 (11, 101),
 (11, 102);
 
INSERT INTO transaction (id, value_date, credit, transaction_type) VALUES
 (1001, {ts '2012-01-12'}, 9540.98, 'Credit'),
 (1002, {ts '2012-01-12'}, 7497.82, 'Credit'),
 (1003, {ts '2012-01-12'}, 9540.98, 'Credit'),
 (1004, {ts '2012-01-12'}, 7497.82, 'Credit');
 
INSERT INTO account_transactions (account_id, transactions_id) VALUES
 (101, 1001),
 (101, 1002),
 (102, 1003),
 (102, 1004);
  