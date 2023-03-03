<div align="center">
    <h1>React Native Block Store</h1>
</div>

<div align="center">
<a href="https://www.npmjs.com/package/react-native-block-store">
    <img src="https://img.shields.io/npm/v/react-native-block-store.svg?style=for-the-badge&color=4284F3" />
</a>
<a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge" />
</a>
</div>

---

> Many users still manage their own credentials when setting up a new Android device. This manual process can become challenging and often results in a poor user experience. The Block Store API, a library powered by Google Play services, looks to solve this by providing a way for apps to save user credentials without the complexity or security risk associated with saving user passwords.

Read more about it [here](https://developers.google.com/identity/blockstore/android).

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
