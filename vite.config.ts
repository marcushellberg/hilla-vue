import { UserConfigFn } from 'vite';
import { overrideVaadinConfig } from './vite.generated';
import vue from '@vitejs/plugin-vue';

const customConfig: UserConfigFn = (env) => ({
  plugins: [
    vue({
      template: {
        compilerOptions: {
          // treat all tags with a dash as custom elements
          isCustomElement: (tag) => tag.includes('-')
        }
      }
    })
  ],
});

export default overrideVaadinConfig(customConfig);
