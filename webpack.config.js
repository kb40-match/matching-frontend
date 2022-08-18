module.exports = {
  chainWebpack: config => {
    const svgRule = config.module.rule('svg')

    // clear all existing loaders.
    // if you don't do this, the loader below will be appended to
    // existing loaders of the rule.
    svgRule.uses.clear()

    // add replacement loader(s)
    svgRule
      .use('vue-svg-loader')
      .loader('vue-svg-loader')
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
        use: ["vue-svg-loader"],
      },
    ],
  },
};
