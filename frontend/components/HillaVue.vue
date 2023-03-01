<script setup lang="ts">
import "@vaadin/grid";
import "@vaadin/text-field";
import "@vaadin/email-field";
import "@vaadin/button";
import {CustomerEndpoint} from "../generated/endpoints.js";
import {ref} from "vue";

const customers = ref(await CustomerEndpoint.getCustomers());
const name = ref('');
const email = ref('');

async function addCustomer() {
  const saved = await CustomerEndpoint.add(name.value, email.value);
  // Need to update the array instance for Vaadin Grid to pick it up.
  customers.value = [...customers.value, saved];
  name.value = '';
  email.value = '';
}

</script>


<template>
  <h2>Todo!</h2>
  <div class="form">
    <vaadin-text-field label="Name" v-model="name"></vaadin-text-field>
    <vaadin-email-field label="Email" v-model="email"></vaadin-email-field>
    <vaadin-button theme="primary" @click="addCustomer">Add</vaadin-button>
  </div>

  <vaadin-grid :items="customers">
    <vaadin-grid-column path="name"></vaadin-grid-column>
    <vaadin-grid-column path="email"></vaadin-grid-column>
  </vaadin-grid>
</template>

<style scoped>
.form {
  display: flex;
  gap: 12px;
  align-items: baseline;
  margin-bottom: 12px;
}
</style>