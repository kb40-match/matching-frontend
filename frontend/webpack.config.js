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
      "/kafka-server": {
        target: "http://10.214.4.235:8083/kafka-server",
        changeOrigin: true,
      },
      "http://10.214.3.43:8081/match": {
        target: "http://10.214.3.43:8081/match",
        changeOrigin: true,
      },
      "http://matching.169.56.100.104.nip.io/match": {
        target: "http://matching.169.56.100.104.nip.io/match`",
        changeOrigin: true,
      },
    },
  },
};
