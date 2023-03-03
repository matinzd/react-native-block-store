import * as React from 'react';

import { StyleSheet, View, Text, Button } from 'react-native';
import { save, retrieve } from 'react-native-block-store';

export default function App() {
  React.useEffect(() => {}, []);

  const onSave = () => {
    save('key1', 'value1').then((success) => {
      console.log({ success });
    });
  };

  const onRetrieve = () => {
    retrieve('key1').then((result) => {
      console.log('Result: ', { result });
    });
  };

  return (
    <View style={styles.container}>
      <Text>{'React Native Block Store'}</Text>
      <Button title={'Save'} onPress={onSave} />
      <Button title={'Retrieve'} onPress={onRetrieve} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    rowGap: 24,
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
