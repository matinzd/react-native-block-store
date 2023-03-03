# react-native-block-store

React Native implementation for Android Block Store

## Installation

```sh
yarn add react-native-block-store
```

## Usage

```js
import BlockStore from 'react-native-block-store';

// ...

const key = 'key1';
const value = 'value1';

const success = await BlockStore.save(key, value);
const result = await BlockStore.retrieve(key);
const isRemoved = await BlockStore.remove(key);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
