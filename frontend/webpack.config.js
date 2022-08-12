module.exports = {
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
  devServer: {
    proxy: {
      "http://matching.169.56.100.104.nip.io/match": {
        target: "http://matching.169.56.100.104.nip.io/match`",
        changeOrigin: true,
      },
      "http://10.214.3.43:8081/match": {
        target: "http://10.214.3.43:8081/match",
        // secure: false,
        changeOrigin: true,
      },
    },
  },
};
