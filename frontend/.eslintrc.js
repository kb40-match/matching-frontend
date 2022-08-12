// module.exports = {
//   root: true,
//   env: {
//     node: true,
//   },
//   extends: [
//     "plugin:vue/essential",
//     "eslint:recommended",
//     "plugin:prettier/recommended",
//   ],
//   parserOptions: {
//     parser: "@babel/eslint-parser",
//   },
//   rules: {
//     semi: ["warn", "always"],
//     "import/prefer-default-export": "off",
//     "import/no-unresolved": "error",
//     "import/no-anonymous-default-export": "off",
//     "import/no-extraneous-dependencies": [
//       "error",
//       {
//         devDependencies: [".storybook/**", "src/stories/**"],
//       },
//     ],
//     "no-param-reassign": ["error", { props: false }],
//     "no-use-before-define": "off",
//     // "@typescript-eslint/no-use-before-define": "off",
//     "no-unused-expressions": ["warn"],
//     // "@typescript-eslint/no-redeclare": "off",
//     // "@typescript-eslint/no-shadow": ["error"],
//     // "@typescript-eslint/camelcase": "off",
//     // "@typescript-eslint/unbound-method": "off",
//     // "@typescript-eslint/no-non-null-assertion": "off",
//     // "@typescript-eslint/no-unsafe-member-access": "off",
//     // "@typescript-eslint/no-unsafe-assignment": "off",
//     // "@typescript-eslint/no-unused-vars": ["warn", { argsIgnorePattern: "^_" }],
//     "prefer-const": ["warn"],
//     "prefer-destructuring": ["error", { object: true, array: false }],
//     "lines-between-class-members": "off",
//     "jsx-a11y/click-events-have-key-events": "off",
//     "jsx-a11y/label-has-associated-control": [
//       "error",
//       {
//         labelComponents: ["label"],
//         labelAttributes: ["htmlFor"],
//         controlComponents: ["input"],
//       },
//     ],
//     "import/extensions": [
//       "error",
//       "ignorePackages",
//       {
//         js: "never",
//         jsx: "never",
//         ts: "never",
//         tsx: "never",
//       },
//     ],
//     "no-console": process.env.NODE_ENV === "production" ? "warn" : "off",
//     "no-debugger": process.env.NODE_ENV === "production" ? "warn" : "off",
//     "prettier/prettier": [
//       "error",
//       {
//         singleQuote: true,
//         semi: true,
//         useTabs: true,
//         tabWidth: 2,
//         trailingComma: "all",
//         printWidth: 80,
//         bracketSpacing: true,
//         arrowParens: "avoid",
//       },
//     ],
//   },
// };
