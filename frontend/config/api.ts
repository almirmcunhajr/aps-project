import { API } from "@constants"

import { ApiProps } from "@types"

export default async function api({link}: ApiProps) {
  const res = await fetch(`${API}${link}`, { cache: 'no-store' })
  const data = await res.json()
 
  return data;
}