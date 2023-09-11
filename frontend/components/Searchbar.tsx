"use client";

import React, { useState } from "react";
import { useRouter } from "next/navigation";
import { MdSearch } from 'react-icons/md';

import { Button, Input } from "@components";

import { SearchBarProps } from "@types";

const SearchBar = ({text = ''}: SearchBarProps) => {
  const router = useRouter();

  const [query, setQuery] = useState<string>(text);

  const handleSearch = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (query === '') {
      return alert('O campo não pode ser vazio.')
    }

    router.push(`/search?query=${query}&page=1`);
  };

  return (
    <form className='flex items-center justify-start max-sm:flex-col w-full relative max-sm:gap-4' onSubmit={handleSearch}>
      <div className='flex-1 max-sm:w-full flex gap-2 justify-start items-center relative'>
        <Input
          onChange={setQuery}
          placeholder='Buscar...'
          type='text'
          value={query}
        />
        <Button
          icon={<MdSearch size={24} />}
          type="submit"
        />
      </div>
    </form>
  );
};

export default SearchBar;
