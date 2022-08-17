module.exports = {
  chainWebpack: config => {
    config.module.rules.delete("svg");
  },
  module: {
    rules: [
      {
        test: /\.css$/i,
        use: ["style-loader", "css-loader"],
      },
      {
        test: /\.scss$/i,
        use: ["sass-loader"],
      },
      {
        test: /\.svg$/,
        use: ["babel-loader", "vue-svg-loader"],
      },
    ],
  },
};
