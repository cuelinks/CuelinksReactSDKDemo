/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React,{useState} from 'react';
import type {PropsWithChildren} from 'react';
import CueLinkModule from './CueLinkModule';
import {
  SafeAreaView,
  StatusBar,
  StyleSheet,
  Text,
  Button,
  useColorScheme,
  TouchableOpacity,
  View,
  Linking,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';


function App(): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  const [valueFromNativeModule, setValueFromNativeModule] = useState(null);

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };
  const handleLinkClick = async (url) => {
     const modifiedLink = await CueLinkModule.getAffiliateLink(url);
     Linking.openURL(modifiedLink);

    };

  return (
        <View style={styles.centered}>
        <TouchableOpacity onPress={() => handleLinkClick('https://example.com')}>
                <Text style={styles.sectionTitle}>Click Here To Generate Test Link!</Text>
        </TouchableOpacity>
        </View>
  );
}

const styles = StyleSheet.create({

  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  highlight: {
    fontWeight: '700',
  },
  centered: {
      flex : 1,
      justifyContent: "center",
      alignItems: "center",
  },
});

export default App;
