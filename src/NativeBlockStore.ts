import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  save(
    key: string,
    value: string,
    shouldBackupToCloud: boolean
  ): Promise<boolean>;
  retrieve(key: string): Promise<string | null>;
  remove(key: string): Promise<boolean>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('BlockStore');
