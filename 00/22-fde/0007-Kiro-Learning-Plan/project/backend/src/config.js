module.exports = {
  JWT_SECRET: process.env.JWT_SECRET || 'dev_secret_change_in_production',
  JWT_EXPIRES_IN: '7d',
  PORT: process.env.PORT || 4000,
};
